package com.sdjyyds.order.web;

import com.sdjyyds.order.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jds
 * @version 1.1
 * @since 1.0.0
 */
@Slf4j
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/createOrder")
     public String createOrder(Order order)
    {
        Boolean flag = orderService.createOrder(order);
        if(flag)
        {
             log.info("订单创建成功");
            return "success";
        }
        log.info("订单创建失败");
        return "fail";
    }
}
