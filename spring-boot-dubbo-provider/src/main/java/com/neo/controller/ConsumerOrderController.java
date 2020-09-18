package com.neo.controller;

import com.neo.entity.Order;
import com.neo.service.ConsumerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by xiaocai on 2020/9/18 9:46
 **/
@RestController
public class ConsumerOrderController {
    @Autowired
    private ConsumerOrderService consumerOrderService;

    @RequestMapping("getOrderList")
    private List<Order> getOrderList(){
        List<Order> orderList = consumerOrderService.getOrderList();
        return orderList;
    }

}
