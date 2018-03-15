package com.fengrun.demo.mvc.action;

import com.fengrun.demo.service.DemoService;
import com.fengrun.mvcframework.annotation.NBAutowried;
import com.fengrun.mvcframework.annotation.NBController;
import com.fengrun.mvcframework.annotation.NBRequestMapping;
import com.fengrun.mvcframework.annotation.NBRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@NBController
@NBRequestMapping("/web")
public class DemoAction {
    @NBAutowried
    DemoService demoService;
    @NBRequestMapping("/query.json")
    public void query(HttpServletRequest request, HttpServletResponse response,@NBRequestParam String name){
        String result = demoService.get(name);
        try {
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
