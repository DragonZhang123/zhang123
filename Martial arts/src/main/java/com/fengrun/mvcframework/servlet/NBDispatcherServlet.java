package com.fengrun.mvcframework.servlet;


import com.fengrun.mvcframework.annotation.NBController;
import com.fengrun.mvcframework.annotation.NBService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * springMVC
 */
public class NBDispatcherServlet extends HttpServlet {

    Properties properties = new Properties();
    private List<String> classNames = new ArrayList<>();
    private Map<String,Object> ioc = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 获取xml (properties)文件所在的路径
        String application = config.getInitParameter("contextConfigLocation");
        System.out.println("application=" +application);
        //
        initStrategies(application);
        //1加载配置文件 applacation.XMl
        doLoadConfig( application);
        //2扫描配置文件中描述的类
        doScanner(properties.getProperty("scanPackage"));
        //3实例化所有被扫描到的类，放到ioc容器
        doInstance();
        //4依赖注入 DI 在ioc容器中找到 @Autowried这个字段的属性，找其在ioc容器中的实例
        //动态赋值
        doAutoWried();
        //5 构造url 和@Controller 把controller  中加了requestMapping 注解的方法 和url构造成一个对应关系 （Map key -url value-method）
        initHandlerMapping();
        //6 等待用户请求，根据用户请求的url 去map 中找到相应的method
        //调用 dopost 或doget
        //通过反射机制动态调用该方法且执行


        System.out.println("NB mvc Framework is init....");






    }

    private void doLoadConfig(String location) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(location);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null!=inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void initHandlerMapping() {
    }

    private void doAutoWried() {
        if (ioc.isEmpty()) return;
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
    //实例化
    private void doInstance() {
        if (classNames.isEmpty()){
            return;
        }
        try {
            for (String className:classNames){
                System.out.println(className);
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(NBController.class)){
                    //首字母小写
                    String beanName = lowerFirst(clazz.getSimpleName());
                    ioc.put(beanName,clazz.newInstance());

                }else if (clazz.isAnnotationPresent(NBService.class)){
                    //同上
                    //依赖注入的接口怎么实例化？？  接口key 实例 其实现类 那个



                    NBService service = clazz.getAnnotation(NBService.class);
                    String beanName = service.value();
                    if("".equals(beanName.trim())){
                         beanName = lowerFirst(clazz.getSimpleName());
                        ioc.put(beanName,clazz.newInstance());
                    }else {
                        ioc.put(beanName,clazz.newInstance());
                        continue;
                    }
                }else {
                    continue;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private String lowerFirst(String str) {
        char[] chars = str.toCharArray();
        chars[0]+=32;
        return String.valueOf(chars);
    }

    //递归扫描
    private void doScanner(String packageName) {
        URL url = this.getClass().getClassLoader().getResource("/"+packageName.replaceAll("\\.","/"));
        File dir = new File(url.getFile());
        for (File file:dir.listFiles()) {
            if (file.isDirectory()){
                doScanner(packageName+"."+file.getName());
            }else {
                classNames.add(packageName+"."+file.getName().replace(".class","").trim());

            }

        }
    }


//spring mvc 原本的
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
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispacher();
    }

    private void doDispacher() {
    }


}
