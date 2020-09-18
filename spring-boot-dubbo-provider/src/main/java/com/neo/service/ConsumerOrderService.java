package com.neo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.neo.api.OrderService;
import com.neo.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by xiaocai on 2020/9/18 9:45
 **/
@Service
public class ConsumerOrderService {
    @Reference
    private OrderService orderService;

    public List<Order> getOrderList(){
        List<Order> orderList = orderService.getOrderList();
        return orderList;
    }
}
