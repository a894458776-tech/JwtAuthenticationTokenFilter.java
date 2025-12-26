/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.WeChatWebhookUtil
 *  com.kylin.kton.system.domain.KtonMerchant
 *  com.kylin.kton.system.domain.KtonTicket
 *  com.kylin.kton.system.service.impl.KtonTicketServiceImpl
 *  org.springframework.beans.BeanUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.ticket.service.impl;

import com.kylin.kton.client.ticket.entity.dto.ClientTicketDTO;
import com.kylin.kton.client.ticket.entity.vo.ClientTicketAddVO;
import com.kylin.kton.client.ticket.entity.vo.ClientTicketEditVO;
import com.kylin.kton.client.ticket.entity.vo.ClientTicketSearchVO;
import com.kylin.kton.client.ticket.mapper.ClientTicketMapper;
import com.kylin.kton.client.ticket.service.ClientTicketService;
import com.kylin.kton.common.utils.WeChatWebhookUtil;
import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.domain.KtonTicket;
import com.kylin.kton.system.service.impl.KtonTicketServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientTicketServiceImpl
extends KtonTicketServiceImpl
implements ClientTicketService {
    @Autowired
    private ClientTicketMapper clientTicketMapper;

    @Override
    public List<ClientTicketDTO> list(ClientTicketSearchVO searchVO) {
        return this.clientTicketMapper.list(searchVO);
    }

    @Override
    public Integer add(ClientTicketAddVO addVO) {
        KtonTicket ticket = new KtonTicket();
        BeanUtils.copyProperties((Object)addVO, (Object)ticket);
        ticket.setTicketNo(this.getNoTime());
        ticket.setCreateTime(new Date());
        return this.clientTicketMapper.insertKtonTicket(ticket);
    }

    @Override
    public Integer edit(ClientTicketEditVO editVO) {
        KtonTicket ticket = new KtonTicket();
        BeanUtils.copyProperties((Object)editVO, (Object)ticket);
        ticket.setUpdateTime(new Date());
        return this.clientTicketMapper.updateKtonTicket(ticket);
    }

    private String getNoTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 5; ++i) {
            result = result + random.nextInt(10);
        }
        return "N" + newDate + result;
    }

    private void doSendMessage(KtonMerchant merchant, String eventType, KtonTicket ticket) {
        String message = this.buildMessage(merchant, eventType);
        System.out.println("Sending message: " + message);
        WeChatWebhookUtil.sendMessage((String)message);
    }

    private String buildMessage(KtonMerchant merchant, String eventType) {
        Date subtime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(subtime);
        String msg = "";
        if ("\u8d44\u6599\u7533\u8bf7".equals(eventType)) {
            msg = "\u4e1a\u52a1\u4e8b\u4ef6\u901a\u77e5\uff1a\n\u8d44\u6599\u7533\u8bf7\uff1a\n\u7528\u6237\uff1a" + merchant.getName() + "\n\u7533\u8bf7\u8d44\u6599\u5ba1\u6838\uff1a\n\u7533\u8bf7\u65f6\u95f4" + formattedDate;
        } else if ("\u5176\u4ed6".equals(eventType)) {
            msg = "\u4e1a\u52a1\u4e8b\u4ef6\u901a\u77e5\uff1a\n\u5176\u4ed6\u4e8b\u4ef6\uff1a\n\u7528\u6237\uff1a" + merchant.getName() + "\n\u7533\u8bf7\u65f6\u95f4" + formattedDate;
        }
        return msg;
    }
}

