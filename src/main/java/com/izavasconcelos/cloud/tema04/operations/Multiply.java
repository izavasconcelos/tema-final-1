package com.izavasconcelos.cloud.tema04.operations;


public class Multiply implements Operation{

    private double firstValue;
    private double secondValue;

    public Multiply(double firstValue, double secondValue) {
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
        return firstValue * secondValue;
    }

    @Override
    public String toString() {
        return "\n" + this.firstValue + " * " + this.secondValue + " = " + doOperation();
    }
}
