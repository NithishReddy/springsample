package com.example.springrocking.service;

import com.example.springrocking.requests.OrdersRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springrocking.entity.Ordermodel;
import com.example.springrocking.repository.OrdermodelRepo;

import org.springframework.beans.BeanUtils;
//import com.example.aopcustom.aop.LogAnnotation;

@Service
public class OrderService implements OrderServiceImpl{


    @Autowired
    private OrdermodelRepo orderModelRepository;


    @Override
    //@LogAnnotation
    public List<Ordermodel> fetchOrderModelList(){
        return (List<Ordermodel>) orderModelRepository.findAll();
    }

    @Override
    //@LogAnnotation
    public OrdersRequest saveOrderModel(OrdersRequest request){

        Ordermodel ordermodel = new Ordermodel();

        BeanUtils.copyProperties(request, ordermodel, "id");

        ordermodel.setId(request.getId());

        System.out.println("order request" + request);
        System.out.print("Ordemodel obkect" + ordermodel);


        orderModelRepository.save(ordermodel);
        OrdersRequest response = new OrdersRequest();
        BeanUtils.copyProperties(ordermodel, response);
        return response;
    }
}
