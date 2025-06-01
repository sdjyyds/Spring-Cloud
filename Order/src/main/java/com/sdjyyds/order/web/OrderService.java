package com.sdjyyds.order.web;

import com.sdjyyds.order.entity.Order;
import com.sdjyyds.order.entity.User;
import com.sdjyyds.order.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author jds
 * @version 1.1
 * @since 1.0.0
 */
@Slf4j
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    public Boolean createOrder(Order order) {
        if (order.getUserId() == null) {
            log.error("用户ID不能为空");
            return false;
        }
        //1.查询用户
        try {
            String url = "http://user-service/user/" + order.getUserId();  // 匹配修正后的Controller路径
            User user = restTemplate.getForObject(url, User.class);
            if (user == null) {
                log.error("用户不存在，ID: {}", order.getUserId());
                return false;
            }
            order.setUser(user);
        } catch (RestClientException e) {
            log.error("调用用户服务失败: {}", e.getMessage());
            return false;
        }
        //2.创建订单
        orderMapper.insertOrder(order);
        return true;
    }
}
