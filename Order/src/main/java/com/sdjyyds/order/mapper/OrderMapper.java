package com.sdjyyds.order.mapper;

import com.sdjyyds.order.entity.Order;

/**
 * @author jds
 * @version 1.1
 * @since 1.0.0
 */
public interface OrderMapper {
    Order queryOrderById(int id);
    Boolean insertOrder( Order order);
}
