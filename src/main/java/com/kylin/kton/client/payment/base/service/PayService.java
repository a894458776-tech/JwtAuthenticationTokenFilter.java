/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.client.payment.base.service;

import com.kylin.kton.client.payment.base.constants.PayConstants;
import com.kylin.kton.client.payment.base.entity.dto.PayResultDTO;

public interface PayService {
    public PayConstants.Payment getPayment();

    public PayResultDTO pay(Long var1);
}

