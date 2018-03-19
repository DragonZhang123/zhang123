package main.java.fengrun.demo.mvc.action;



import main.java.fengrun.demo.service.DemoService;
import main.java.fengrun.mvcframework.annotation.NBAutowried;
import main.java.fengrun.mvcframework.annotation.NBController;
import main.java.fengrun.mvcframework.annotation.NBRequestMapping;
import main.java.fengrun.mvcframework.annotation.NBRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@NBController
@NBRequestMapping("/web")
public class DemoAction {
    @NBAutowried("demoService")
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
