/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.system.domain.KtonTicket
 *  io.swagger.annotations.Api
 *  io.swagger.annotations.ApiOperation
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.ticket.controller;

import com.kylin.kton.client.ticket.entity.vo.ClientTicketAddVO;
import com.kylin.kton.client.ticket.entity.vo.ClientTicketEditVO;
import com.kylin.kton.client.ticket.service.ClientTicketService;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.system.domain.KtonTicket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"\u5ba2\u6237\u7aef\u5de5\u5355\u6a21\u5757"})
@RestController
@RequestMapping(value={"/client/ticket"})
public class ClientTicketController
extends BaseController {
    @Autowired
    private ClientTicketService ktonTicketService;

    @ApiOperation(value="\u5de5\u5355\u5217\u8868")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonTicket ktonTicket) {
        this.startPage();
        List list = this.ktonTicketService.selectKtonTicketList(ktonTicket);
        return this.getDataTable(list);
    }

    @ApiOperation(value="\u5de5\u5355\u8be6\u60c5")
    @GetMapping(value={"/detail/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonTicketService.selectKtonTicketById(id));
    }

    @ApiOperation(value="\u521b\u5efa\u5de5\u5355")
    @PostMapping(value={"/add"})
    public AjaxResult add(@RequestBody ClientTicketAddVO addVO) {
        return this.toAjax(this.ktonTicketService.add(addVO));
    }

    @ApiOperation(value="\u4fee\u6539\u5de5\u5355")
    @PostMapping(value={"/edit"})
    public AjaxResult edit(@RequestBody ClientTicketEditVO editVO) {
        return this.toAjax(this.ktonTicketService.edit(editVO));
    }
}

