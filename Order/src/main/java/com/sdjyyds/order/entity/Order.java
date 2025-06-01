package com.sdjyyds.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jds
 * @version 1.1
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    public enum Status {
        PENDING, PAID, SHIPPED, COMPLETED, CANCELLED, REFUNDED
    }
    private Integer id;
    private Integer userId;
    private Date orderTime;
    private Status status = Status.PENDING;
    private BigDecimal totalPrice;
    private String address;
    private String comment;
    /**
     * 设置关联用户，并自动填充用户信息到订单
     * @param user 用户对象
     */
    public void setUser(User user) {
        if (user != null) {
            this.userId = user.getId();          // 设置用户ID
            this.address = user.getAddress();    // 默认使用用户地址作为收货地址
        }
    }
}
