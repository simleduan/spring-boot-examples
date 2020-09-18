package com.neo.api;

import com.neo.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrderList();
}
