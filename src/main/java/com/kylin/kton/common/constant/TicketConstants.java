package com.kylin.kton.common.constant;

/**
 * 工单常量定义
 */
public class TicketConstants {

    /**
     * 修复点1：将 class extends Enum 改为标准的 enum 定义
     * 修复点2：反编译代码丢失了枚举值，我补全了常用的工单状态
     * (如果你的代码中引用了其他状态名，请在这里添加)
     */
    public enum STATUS {
        WAIT_CUST_CONFIRM, // 待客户确认
        WAIT_SERV_CONFIRM, // 待客服确认
        PROCESSING,        // 处理中
        FINISHED,          // 已完成
        CLOSED             // 已关闭
    }

    public enum TICKET_TYPE {
        SUPLIER // 供应商
    }
}