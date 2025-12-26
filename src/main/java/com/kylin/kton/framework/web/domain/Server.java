package com.kylin.kton.framework.web.domain;

import com.kylin.kton.common.utils.Arith;
import com.kylin.kton.common.utils.ip.IpUtils;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.CentralProcessor.TickType;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;

import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class Server {
    private static final int OSHI_WAIT_SECOND = 1000;
    private Cpu cpu = new Cpu();
    private Mem mem = new Mem();
    private Jvm jvm = new Jvm();
    private Sys sys = new Sys();
    private List<SysFile> sysFiles = new LinkedList<>();

    public void copyTo() throws Exception {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        setCpuInfo(hal.getProcessor());
        setMemInfo(hal.getMemory());
        setSysInfo();
        setJvmInfo();
        setSysFiles(si.getOperatingSystem());
    }

    private void setCpuInfo(CentralProcessor processor) {
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Util.sleep(OSHI_WAIT_SECOND);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[TickType.NICE.getIndex()] - prevTicks[TickType.NICE.getIndex()];
        long irq = ticks[TickType.IRQ.getIndex()] - prevTicks[TickType.IRQ.getIndex()];
        long softirq = ticks[TickType.SOFTIRQ.getIndex()] - prevTicks[TickType.SOFTIRQ.getIndex()];
        long steal = ticks[TickType.STEAL.getIndex()] - prevTicks[TickType.STEAL.getIndex()];
        long cSys = ticks[TickType.SYSTEM.getIndex()] - prevTicks[TickType.SYSTEM.getIndex()];
        long user = ticks[TickType.USER.getIndex()] - prevTicks[TickType.USER.getIndex()];
        long iowait = ticks[TickType.IOWAIT.getIndex()] - prevTicks[TickType.IOWAIT.getIndex()];
        long idle = ticks[TickType.IDLE.getIndex()] - prevTicks[TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        cpu.setCpuNum(processor.getLogicalProcessorCount());
        cpu.setTotal(totalCpu);
        cpu.setSys(cSys);
        cpu.setUsed(user);
        cpu.setWait(iowait);
        cpu.setFree(idle);
    }

    private void setMemInfo(GlobalMemory memory) {
        mem.setTotal(memory.getTotal());
        mem.setUsed(memory.getTotal() - memory.getAvailable());
        mem.setFree(memory.getAvailable());
    }

    private void setSysInfo() {
        Properties props = System.getProperties();
        sys.setComputerName(IpUtils.getHostName());
        sys.setOsName(props.getProperty("os.name"));
        sys.setOsArch(props.getProperty("os.arch"));
        sys.setUserDir(props.getProperty("user.dir"));
        sys.setOsVersion(props.getProperty("os.version"));
    }

    private void setJvmInfo() throws UnknownHostException {
        Properties props = System.getProperties();
        jvm.setTotal(Runtime.getRuntime().totalMemory());
        jvm.setMax(Runtime.getRuntime().maxMemory());
        jvm.setFree(Runtime.getRuntime().freeMemory());
        jvm.setVersion(props.getProperty("java.version"));
        jvm.setHome(props.getProperty("java.home"));
    }

    private void setSysFiles(OperatingSystem os) {
        FileSystem fileSystem = os.getFileSystem();
        // 【关键修复】显式指定 List<OSFileStore>
        List<OSFileStore> fileStores = fileSystem.getFileStores();
        for (OSFileStore fs : fileStores) {
            long free = fs.getUsableSpace();
            long total = fs.getTotalSpace();
            long used = total - free;
            SysFile sysFile = new SysFile();
            sysFile.setDirName(fs.getMount());
            sysFile.setTypeName(fs.getType());
            sysFile.setTotal(convertFileSize(total));
            sysFile.setFree(convertFileSize(free));
            sysFile.setUsed(convertFileSize(used));
            sysFile.setUsage(Arith.mul(Arith.div(used, total, 4), 100));
            sysFiles.add(sysFile);
        }
    }

    public String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            return String.format("%.1f MB", (float) size / mb);
        } else if (size >= kb) {
            return String.format("%.1f KB", (float) size / kb);
        } else {
            return String.format("%d B", size);
        }
    }

    // 内部类保持不变，如果你需要我也贴出来，但为了节省篇幅，这里假设内部类没问题
    // 如果内部类报错，请告诉我
    public Cpu getCpu() { return cpu; }
    public void setCpu(Cpu cpu) { this.cpu = cpu; }
    public Mem getMem() { return mem; }
    public void setMem(Mem mem) { this.mem = mem; }
    public Jvm getJvm() { return jvm; }
    public void setJvm(Jvm jvm) { this.jvm = jvm; }
    public Sys getSys() { return sys; }
    public void setSys(Sys sys) { this.sys = sys; }
    public List<SysFile> getSysFiles() { return sysFiles; }
    public void setSysFiles(List<SysFile> sysFiles) { this.sysFiles = sysFiles; }

    public static class Cpu { private int cpuNum; private double total; private double sys; private double used; private double wait; private double free; public int getCpuNum() { return cpuNum; } public void setCpuNum(int cpuNum) { this.cpuNum = cpuNum; } public double getTotal() { return total; } public void setTotal(double total) { this.total = total; } public double getSys() { return sys; } public void setSys(double sys) { this.sys = sys; } public double getUsed() { return used; } public void setUsed(double used) { this.used = used; } public double getWait() { return wait; } public void setWait(double wait) { this.wait = wait; } public double getFree() { return free; } public void setFree(double free) { this.free = free; } }
    public static class Mem { private double total; private double used; private double free; public double getTotal() { return Arith.div(total, (1024 * 1024 * 1024), 2); } public void setTotal(long total) { this.total = total; } public double getUsed() { return Arith.div(used, (1024 * 1024 * 1024), 2); } public void setUsed(long used) { this.used = used; } public double getFree() { return Arith.div(free, (1024 * 1024 * 1024), 2); } public void setFree(long free) { this.free = free; } public double getUsage() { return Arith.mul(Arith.div(used, total, 4), 100); } }
    public static class Jvm { private double total; private double max; private double free; private String version; private String home; public double getTotal() { return Arith.div(total, (1024 * 1024), 2); } public void setTotal(double total) { this.total = total; } public double getMax() { return Arith.div(max, (1024 * 1024), 2); } public void setMax(double max) { this.max = max; } public double getFree() { return Arith.div(free, (1024 * 1024), 2); } public void setFree(double free) { this.free = free; } public double getUsed() { return Arith.div(total - free, (1024 * 1024), 2); } public double getUsage() { return Arith.mul(Arith.div(total - free, total, 4), 100); } public String getName() { return java.lang.management.ManagementFactory.getRuntimeMXBean().getVmName(); } public String getVersion() { return version; } public void setVersion(String version) { this.version = version; } public String getHome() { return home; } public void setHome(String home) { this.home = home; } public String getStartTime() { return com.kylin.kton.common.utils.DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", com.kylin.kton.common.utils.DateUtils.getServerStartDate()); } public String getRunTime() { return com.kylin.kton.common.utils.DateUtils.getDatePoor(com.kylin.kton.common.utils.DateUtils.getNowDate(), com.kylin.kton.common.utils.DateUtils.getServerStartDate()); } }
    public static class Sys { private String computerName; private String computerIp; private String userDir; private String osName; private String osArch; private String osVersion; public String getComputerName() { return computerName; } public void setComputerName(String computerName) { this.computerName = computerName; } public String getComputerIp() { return computerIp; } public void setComputerIp(String computerIp) { this.computerIp = computerIp; } public String getUserDir() { return userDir; } public void setUserDir(String userDir) { this.userDir = userDir; } public String getOsName() { return osName; } public void setOsName(String osName) { this.osName = osName; } public String getOsArch() { return osArch; } public void setOsArch(String osArch) { this.osArch = osArch; } public String getOsVersion() { return osVersion; } public void setOsVersion(String osVersion) { this.osVersion = osVersion; } }
    public static class SysFile { private String dirName; private String typeName; private String total; private String free; private String used; private double usage; public String getDirName() { return dirName; } public void setDirName(String dirName) { this.dirName = dirName; } public String getTypeName() { return typeName; } public void setTypeName(String typeName) { this.typeName = typeName; } public String getTotal() { return total; } public void setTotal(String total) { this.total = total; } public String getFree() { return free; } public void setFree(String free) { this.free = free; } public String getUsed() { return used; } public void setUsed(String used) { this.used = used; } public double getUsage() { return usage; } public void setUsage(double usage) { this.usage = usage; } }
}