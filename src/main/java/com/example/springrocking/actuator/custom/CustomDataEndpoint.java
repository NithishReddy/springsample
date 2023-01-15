package com.example.springrocking.actuator.custom;

import java.net.http.HttpResponse;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import com.example.springrocking.responses.CustomActuator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// This file is used for creating custom endpoint for actuator instead of using existing ones

@Endpoint(id = "hello")
public class CustomDataEndpoint {


    /* @ReadOperation
    public String sayHello() {
        return "hello";
    } */

    public String name;

    public int value;

    public CustomDataEndpoint(){

    }

    public CustomDataEndpoint(String name, int n){
        this.name = name;
        this.value = n;
    }

    @ReadOperation
    public CustomActuator getData(String name) {
        return new CustomActuator(name, 5);
    }
}
