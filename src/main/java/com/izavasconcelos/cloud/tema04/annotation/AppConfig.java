package com.izavasconcelos.cloud.tema04.annotation;

import com.izavasconcelos.cloud.tema04.operations.*;
import com.izavasconcelos.cloud.tema04.service.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.izavasconcelos.cloud.tema04.annotation")

public class AppConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    @Bean(name = "+")
    @Scope("prototype")
    public Sum sum(double firstValue, double secondValue) {
        return new Sum(firstValue,secondValue);
    }

    @Bean(name = "/")
    @Scope("prototype")
    public Division div(double firstValue, double secondValue) {
        return new Division(firstValue,secondValue);
    }

    @Bean(name = "*")
    @Scope("prototype")
    public Multiply mult(double firstValue, double secondValue) {
        return new Multiply(firstValue,secondValue);
    }

    @Bean(name = "pow")
    @Scope("prototype")
    public Pow pow(double firstValue, double secondValue) {
        return new Pow(firstValue,secondValue);
    }

    @Bean(name = "-")
    @Scope("prototype")
    public Sub sub(double firstValue, double secondValue) {
        return new Sub(firstValue,secondValue);
    }

}
