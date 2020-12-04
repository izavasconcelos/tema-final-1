package com.izavasconcelos.cloud.tema04.operations;

import com.izavasconcelos.cloud.tema04.exceptions.DivisionByZeroException;

public class Division implements Operation {

    private double firstValue;
    private double secondValue;

    public Division(double firstValue, double secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Override
    public double getFirstValue() {
        return this.firstValue;
    }

    @Override
    public double getSecondValue() {
        return this.secondValue;
    }

    @Override
    public double doOperation() {
        if(secondValue == 0)
            throw new DivisionByZeroException("Division by zero is undefined!");
        else
        return firstValue / secondValue;
    }

    @Override
    public String toString() {
        return "\n" + this.firstValue + " / " + this.secondValue + " = " + doOperation();
    }
}
