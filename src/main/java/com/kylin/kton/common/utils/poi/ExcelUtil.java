package com.kylin.kton.common.utils.poi;

import com.alibaba.excel.EasyExcel;
import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.exception.CustomServiceException;
import com.kylin.kton.common.utils.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.*;

public class ExcelUtil<T> {
    private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    private Class<T> clazz;

    public ExcelUtil(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void init(List<T> list, String sheetName, String title, Type type) {
        if (list == null) {
            list = new ArrayList<T>();
        }
        this.list = list;
        this.sheetName = sheetName;
        this.type = type;
        this.title = title;
        createExcelField();
        createWorkbook();
    }

    private List<T> list;
    private List<Object[]> fields;
    private String sheetName;
    private Type type;
    private String title;
    private Workbook wb;
    private Sheet sheet;

    public void createExcelField() {
        this.fields = new ArrayList<Object[]>();
        List<Field> tempFields = new ArrayList<>();
        tempFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        for (Field field : tempFields) {
            if (field.isAnnotationPresent(Excel.class)) {
                putToField(field, field.getAnnotation(Excel.class));
            }
        }
    }

    private void putToField(Field field, Excel attr) {
        if (attr != null) {
            this.fields.add(new Object[]{field, attr});
        }
    }

    public void createWorkbook() {
        this.wb = new SXSSFWorkbook(500);
        this.sheet = wb.createSheet();
    }

    public AjaxResult exportExcel(List<T> list, String sheetName) {
        this.init(list, sheetName, StringUtils.EMPTY, Type.EXPORT);
        return exportExcel();
    }

    public AjaxResult exportExcel(List<T> list, String sheetName, String title) {
        this.init(list, sheetName, title, Type.EXPORT);
        return exportExcel();
    }

    public AjaxResult exportExcel(HttpServletResponse response, List<T> list, String sheetName) {
        this.init(list, sheetName, StringUtils.EMPTY, Type.EXPORT);
        return exportExcel(response);
    }

    public AjaxResult exportExcel() {
        OutputStream out = null;
        try {
            String filename = encodingFilename(sheetName);
            out = new java.io.FileOutputStream(getAbsoluteFile(filename));
            wb.write(out);
            return AjaxResult.success(filename);
        } catch (Exception e) {
            log.error("导出Excel异常{}", e.getMessage());
            throw new CustomServiceException("导出Excel失败");
        }
    }

    public AjaxResult exportExcel(HttpServletResponse response) {
        try {
            String filename = encodingFilename(sheetName);
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + filename + ".xlsx");
            wb.write(response.getOutputStream());
        } catch (Exception e) {
            log.error("导出Excel异常{}", e.getMessage());
        }
        return null;
    }

    public void importTemplateExcel(HttpServletResponse response, String sheetName) {
        exportExcel(response, null, sheetName);
    }

    public List<T> importExcel(InputStream is) throws Exception {
        return EasyExcel.read(is).head(clazz).sheet().doReadSync();
    }

    public List<T> importExcel(MultipartFile file) throws Exception {
        return importExcel(file.getInputStream());
    }

    public String encodingFilename(String filename) {
        filename = UUID.randomUUID().toString() + "_" + filename + ".xlsx";
        return filename;
    }

    public String getAbsoluteFile(String filename) {
        String downloadPath = "download/" + filename;
        java.io.File desc = new java.io.File(downloadPath);
        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }

    public enum Type {
        EXPORT, IMPORT
    }
}