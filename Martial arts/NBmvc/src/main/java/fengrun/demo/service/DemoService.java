package main.java.fengrun.demo.service;


import main.java.fengrun.mvcframework.annotation.NBService;

@NBService
public class DemoService {
    public String get(String name) {
        return "My name is "+name;
    }
}
