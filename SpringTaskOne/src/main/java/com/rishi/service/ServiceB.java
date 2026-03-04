package com.rishi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class ServiceB {

    private  ServiceA serviceA;

//    public ServiceB(ServiceA serviceA) {
//        this.serviceA = serviceA;
//    }

    @Autowired
    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}