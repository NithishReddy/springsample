package com.example.springrocking.service;
import com.example.springrocking.requests.OrdersRequest;
import java.util.List;

import com.example.springrocking.entity.Ordermodel;

public interface OrderServiceImpl {
    List<Ordermodel> fetchOrderModelList();

    OrdersRequest saveOrderModel(OrdersRequest request);
}
