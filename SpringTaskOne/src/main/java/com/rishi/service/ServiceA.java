package com.rishi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service

public class ServiceA {

    private  ServiceB serviceB;

    @Lazy
    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;

    }

//    @Autowired
//    public void setServiceB(ServiceB serviceB) {
//        this.serviceB = serviceB;
//
//    }
}