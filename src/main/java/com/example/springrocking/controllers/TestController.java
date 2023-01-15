package com.example.springrocking.controllers;

import com.example.springrocking.requests.OrdersRequest;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrocking.entity.Ordermodel;
import com.example.springrocking.service.OrderService;

@RestController
@RequestMapping("/v1/springrocking")
public class TestController {

    @Value("${appPropFirstValue}")
    private String propValue;

    @Autowired
    private OrderService orderService;

    Logger logger = LoggerFactory.getLogger(getClass());
    
    @RequestMapping(path = "/getmsg",method = RequestMethod.GET)
    public String getMessage(){
        logger.info("This is the first log in project");
        return "Hello World! First API Call : " + this.propValue;
    }


   @RequestMapping(path="/fetch_orders", method= RequestMethod.GET)
    public List<Ordermodel> getOrders(){
        return orderService.fetchOrderModelList();
    } 

    @PostMapping(path="/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public OrdersRequest postOrderData(@RequestBody OrdersRequest request){
        OrdersRequest res= orderService.saveOrderModel(request);
        System.out.println("================Final");
        return res;
    }
}
