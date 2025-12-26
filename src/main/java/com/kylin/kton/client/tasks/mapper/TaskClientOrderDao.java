/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonOrder
 *  com.kylin.kton.system.mapper.KtonOrderMapper
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.tasks.mapper;

import com.kylin.kton.system.domain.KtonOrder;
import com.kylin.kton.system.mapper.KtonOrderMapper;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskClientOrderDao
extends KtonOrderMapper {
    @Select(value={"<script>  SELECT *   FROM kton_order   WHERE paid_status = '10'       AND   create_time &lt;= NOW() - INTERVAL 15 MINUTE </script>"})
    public List<KtonOrder> pendingCancelOrderList();
}

