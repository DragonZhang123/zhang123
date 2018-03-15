package com.fengrun.mvcframework.servlet;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NBDispatcherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //相当于 获取xml 文件所在的路径
        String application = config.getInitParameter("contextConfigLocation");
        System.out.println("application=" +application);
        //
        initStrategies(application);

    }
    protected void initStrategies(String application) {
//        this.initMultipartResolver(application);
//        this.initLocaleResolver(application);
//        this.initThemeResolver(application);
//        this.initHandlerMappings(application);
//        this.initHandlerAdapters(application);
//        this.initHandlerExceptionResolvers(application);
//        this.initRequestToViewNameTranslator(application);
//        this.initViewResolvers(application);
//        this.initFlashMapManager(application);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


}
