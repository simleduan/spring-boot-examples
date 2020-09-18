package com.neo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.neo.api.OrderService;
import com.neo.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * create by xiaocai on 2020/9/18 9:41
 **/
@Service
@Component
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> getOrderList() {
        Order order1 = new Order(1, "客户张老板", "黄鹤楼");
        Order order2 = new Order(11, "客户张女士", "卡姿兰");
        Order order3 = new Order(111, "客户张阿姨", "鸡蛋");
        return Arrays.asList(order1,order2,order3);
    }
}
