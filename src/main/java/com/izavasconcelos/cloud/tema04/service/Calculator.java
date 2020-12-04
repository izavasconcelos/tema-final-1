package com.izavasconcelos.cloud.tema04.service;

import com.izavasconcelos.cloud.tema04.exceptions.InvalidOperationException;
import com.izavasconcelos.cloud.tema04.exceptions.NullOrEmptyOperationException;
import com.izavasconcelos.cloud.tema04.operations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class Calculator {

    private List<Operation> history;

    public Calculator() {
        this.history = new ArrayList<>();
    }

    public List<Operation> getHistory() {
        return history;
    }

    @Autowired
    private ApplicationContext appContext;

    public double doOperation( double firstValue, String op, double secondValue) {
        if(op == null || op.isEmpty())
            throw new NullOrEmptyOperationException("Null or Empty Operation!");

        if(!appContext.containsBeanDefinition(op))
            throw new InvalidOperationException("Invalid Operation!");

        Operation operation = (Operation) appContext.getBean(op, firstValue,secondValue);
        history.add(operation);

        return operation.doOperation();
    }
}
