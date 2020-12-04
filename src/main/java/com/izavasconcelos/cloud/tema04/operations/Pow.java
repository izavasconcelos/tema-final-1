package com.izavasconcelos.cloud.tema04.operations;

import java.text.DecimalFormat;

public class Pow implements Operation {

    private double firstValue;
    private double secondValue;

    public Pow(double firstValue, double secondValue) {
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
        return Math.pow(firstValue, secondValue);
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.0000");
        return "\n" + this.firstValue + "^("+ (int)this.secondValue + ") = " + (doOperation() > 1 ? doOperation() : decimalFormat.format(doOperation()));
    }
}
