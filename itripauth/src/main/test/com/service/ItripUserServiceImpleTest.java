package com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ItripUserServiceImpleTest {

    @Test
    public void testtt(){
        ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        System.out.println(app.getBeanDefinitionCount());
    }

}