/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Log
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.enums.BusinessType
 *  com.kylin.kton.common.utils.poi.ExcelUtil
 *  com.kylin.kton.system.domain.KtonTicket
 *  javax.servlet.http.HttpServletResponse
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.web.bind.annotation.DeleteMapping
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.PutMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.admin.ticket.controller;

import com.kylin.kton.admin.ticket.entity.vo.AdminAuditVO;
import com.kylin.kton.admin.ticket.entity.vo.AdminTicketAddVO;
import com.kylin.kton.admin.ticket.entity.vo.AdminTicketEditVO;
import com.kylin.kton.admin.ticket.service.TicketService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonTicket;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/admin/ticket"})
public class KtonTicketController
extends BaseController {
    @Autowired
    private TicketService ktonTicketService;

    @PreAuthorize(value="@ss.hasPermi('system:ticket:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonTicket ktonTicket) {
        this.startPage();
        List list = this.ktonTicketService.selectKtonTicketList(ktonTicket);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:ticket:export')")
    @Log(title="\u5546\u6237\u5de5\u5355", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonTicket ktonTicket) {
        List list = this.ktonTicketService.selectKtonTicketList(ktonTicket);
        ExcelUtil util = new ExcelUtil(KtonTicket.class);
        util.exportExcel(response, list, "\u5546\u6237\u5de5\u5355\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:ticket:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonTicketService.selectKtonTicketById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:ticket:add')")
    @Log(title="\u5546\u6237\u5de5\u5355", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AdminTicketAddVO addVO) {
        return this.toAjax(this.ktonTicketService.add(addVO));
    }

    @PreAuthorize(value="@ss.hasPermi('system:ticket:edit')")
    @Log(title="\u5546\u6237\u5de5\u5355", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AdminTicketEditVO editVO) {
        return this.toAjax(this.ktonTicketService.edit(editVO));
    }

    @PreAuthorize(value="@ss.hasPermi('system:ticket:remove')")
    @Log(title="\u5546\u6237\u5de5\u5355", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonTicketService.deleteKtonTicketByIds(ids));
    }

    @PostMapping(value={"/audit"})
    public AjaxResult audit(@RequestBody AdminAuditVO auditVO) {
        return this.toAjax(this.ktonTicketService.audit(auditVO));
    }
}

