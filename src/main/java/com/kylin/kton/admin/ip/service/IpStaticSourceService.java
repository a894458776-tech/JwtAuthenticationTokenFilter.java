/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.system.service.IKtonIpStaticSourceService
 *  org.springframework.web.multipart.MultipartFile
 */
package com.kylin.kton.admin.ip.service;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticSourceDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminAddByIpPatternVO;
import com.kylin.kton.admin.ip.entity.vo.AdminImportIpSourceVO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticSourceSearchVO;
import com.kylin.kton.admin.ip.entity.vo.AdminPutOffIpSourceVO;
import com.kylin.kton.admin.ip.entity.vo.AdminWithOutPoolSearchVO;
import com.kylin.kton.admin.ip.entity.vo.PutOnIpSourceVO;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.system.service.IKtonIpStaticSourceService;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface IpStaticSourceService
extends IKtonIpStaticSourceService {
    public List<AdminIpStaticSourceDTO> list(AdminIpStaticSourceSearchVO var1);

    public List<AdminIpStaticSourceDTO> withOutPoolList(AdminWithOutPoolSearchVO var1);

    public Integer importIpSource(AdminImportIpSourceVO var1);

    public int putOnIpSource(PutOnIpSourceVO var1);

    public void putOffIpSource(AdminPutOffIpSourceVO var1);

    public Integer addByIpPattern(AdminAddByIpPatternVO var1);

    public AjaxResult importIpExcel(MultipartFile var1);
}

