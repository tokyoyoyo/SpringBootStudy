package com.coder.servlet;


import com.sun.corba.se.impl.protocol.ServantCacheLocalCRDBase;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//@Configuration
public class MyRegistConfig {

//    @Bean
    public ServletRegistrationBean myServlet(){

        return new ServletRegistrationBean(new Myservlet(),"/my","/my2");
    }

//    @Bean
    public FilterRegistrationBean myFilter(){

//        return new FilterRegistrationBean( new MyFilter(),myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/my2"));

        return filterRegistrationBean;
    }

//    @Bean
    public ServletListenerRegistrationBean myListener(){


        return new ServletListenerRegistrationBean(new MyServletContextListener());
    }
}
