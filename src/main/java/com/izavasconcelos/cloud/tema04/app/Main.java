package com.izavasconcelos.cloud.tema04.app;

import com.izavasconcelos.cloud.tema04.annotation.AppConfig;
import com.izavasconcelos.cloud.tema04.service.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) appContext.getBean("calculator");

        System.out.println(calculator.doOperation(3,"+",  5));

        System.out.println(calculator.doOperation(3,"*",  5));

        System.out.println(calculator.doOperation(3,"/",  5));

        System.out.println(calculator.doOperation(3,"pow",  5));

        System.out.println(calculator.doOperation(3,"-",  5));

        System.out.println(calculator.getHistory());
        ((AnnotationConfigApplicationContext)appContext).close();
    }
}
