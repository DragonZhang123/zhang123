package com.fengrun.demo.service;

import com.fengrun.mvcframework.annotation.NBService;

@NBService
public class DemoService {
    public String get(String name) {
        return "My name is "+name;
    }
}
