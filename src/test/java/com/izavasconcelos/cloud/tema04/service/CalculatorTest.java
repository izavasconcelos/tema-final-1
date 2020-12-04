package com.izavasconcelos.cloud.tema04.service;

import com.izavasconcelos.cloud.tema04.annotation.AppConfig;
import com.izavasconcelos.cloud.tema04.exceptions.DivisionByZeroException;
import com.izavasconcelos.cloud.tema04.exceptions.InvalidOperationException;
import com.izavasconcelos.cloud.tema04.exceptions.NullOrEmptyOperationException;
import com.izavasconcelos.cloud.tema04.operations.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static jdk.nashorn.internal.objects.Global.Infinity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})

public class CalculatorTest{


    @Autowired
    private Calculator calculator;

    @Test
    public void sumTest() {
        double result = calculator.doOperation(2.2, "+", 3);
        Assert.assertEquals(5.2, result, 0.01);

        result = calculator.doOperation(32344542.2, "+", -9283711);
        Assert.assertEquals(23060831.2, result, 0.000001);

        result = calculator.doOperation(599999999E3, "+", 928371199);
        Assert.assertEquals(600928370.199E3, result, 0.000001);

        result = calculator.doOperation(999999999E4, "+", 1528371198);
        Assert.assertEquals(1.0001528361198E13, result, 0.000001);

    }

    @Test
    public void divisionTest() {
        double result = calculator.doOperation(4, "/", 2);
        Assert.assertEquals(2, result, 0.00001);

        result = calculator.doOperation(0, "/", 2);
        Assert.assertEquals(0, result, 0.000001);

        result = calculator.doOperation(567.89, "/", -72.30);
        Assert.assertEquals(-7.85463347, result, 0.000001);

        result = calculator.doOperation(999999999, "/", 1111111111);
        Assert.assertEquals(0.899999, result, 0.00001);

        result = calculator.doOperation(-1283243.456, "/", -12.34);
        Assert.assertEquals(103990.555591, result, 0.00001);

        result = calculator.doOperation(10000000E13, "/", 116516516461651E15);
        Assert.assertEquals(0.0000000008582474230845455, result, 0.000000000000000000000001);
    }

    @Test
    public void multTest() {
        double result = calculator.doOperation(5, "*" ,67);
        Assert.assertEquals(335, result, 0.00000001);

        result = calculator.doOperation(34535434534.534534535, "*", 0);
        Assert.assertEquals(0, result, 0.0000000001);

        result = calculator.doOperation(-1827198271, "*", 837498273E13);
        Assert.assertEquals(-1530275396391086E16, result, 0.00000000001);

        result = calculator.doOperation(0.0008912E-10, "*", 0.12123E-3);
        Assert.assertEquals(1.0804017600000001E-17, result, 0.000000000000000000000000000000000000000001);
    }

    @Test
    public void powTest() {
        double result = calculator.doOperation(3, "pow" , -5);
        Assert.assertEquals(0.00411522633744856, result, 0.000000000000001);

        result = calculator.doOperation(10, "pow" , 1);
        Assert.assertEquals(10, result, 0.000000000000001);

        result = calculator.doOperation(7, "pow" , 0);
        Assert.assertEquals(1, result, 0.0000000000000001);

        result = calculator.doOperation(2, "pow" , 20);
        Assert.assertEquals(1048576, result, 0.0000000000000001);

        result = calculator.doOperation(22, "pow" , -20);
        Assert.assertEquals(1.4175761034407014E-27, result, 0.00000000000000000000000000000000000000001);

        result = calculator.doOperation(98765, "pow" , -563);
        Assert.assertEquals(0, result, 0.0000000000000000000000000000000000000000000000000000000001);

        result = calculator.doOperation(21082912, "pow" , 710);
        Assert.assertEquals(Infinity, result, 0.0000000000001);
    }

    @Test
    public void subTest() {
         double result = calculator.doOperation(33 , "-", 15);
         Assert.assertEquals(18, result, 0.001);

        result = calculator.doOperation(234709232 , "-", 151212112121.212121212121E10);
        Assert.assertEquals(-1.5121211212118866E21, result, 0.000000000000000000001);

        result = calculator.doOperation(0.4334709232 , "-", -399999.90);
        Assert.assertEquals(400000.33347092324, result, 0.000000000000000000001);

        result = calculator.doOperation(-9999999 , "-", -10000001.10);
        Assert.assertEquals(2.099999999627471, result, 0.0000000000001);
    }

    @Test (expected = NullOrEmptyOperationException.class)
    public void nullOperationTest() {
        double result = calculator.doOperation(4, null , 5);
        Assert.assertEquals(18, result, 0.001);
    }

    @Test (expected = NullOrEmptyOperationException.class)
    public void emptyOperationTest() {
        double result = calculator.doOperation(4, "" , 5);
        Assert.assertEquals(18, result, 0.001);
    }

    @Test (expected = DivisionByZeroException.class)
    public void divisionByZeroTest() {
        double result = calculator.doOperation(900,"/", 0);
        Assert.assertEquals(4.5, result, 0.01);
    }

    @Test (expected = InvalidOperationException.class)
    public void invalidOperationTest() {
        double result = calculator.doOperation(234234, "#" , 234234);
        Assert.assertEquals(1800, result, 0.0000001);
    }

    @Test
    public void historyTest() {
        calculator.getHistory().clear();

        calculator.doOperation(10, "+",24);
        calculator.doOperation(33, "-",3);
        calculator.doOperation(50, "/", 5);
        calculator.doOperation(15, "*",10);
        calculator.doOperation(2, "pow",6);

        Assert.assertEquals(5, calculator.getHistory().size());

        Assert.assertEquals(10, calculator.getHistory().get(0).getFirstValue(), 0.001);
        Assert.assertEquals(24, calculator.getHistory().get(0).getSecondValue(), 0.001);
        Assert.assertEquals(34, calculator.getHistory().get(0).doOperation(), 0.001);
        Assert.assertTrue(calculator.getHistory().get(0) instanceof Sum);

        Assert.assertEquals(33, calculator.getHistory().get(1).getFirstValue(), 0.001);
        Assert.assertEquals(3, calculator.getHistory().get(1).getSecondValue(), 0.001);
        Assert.assertEquals(30, calculator.getHistory().get(1).doOperation(), 0.001);
        Assert.assertTrue(calculator.getHistory().get(1) instanceof Sub);

        Assert.assertEquals(50, calculator.getHistory().get(2).getFirstValue(), 0.001);
        Assert.assertEquals(5, calculator.getHistory().get(2).getSecondValue(), 0.001);
        Assert.assertEquals(10, calculator.getHistory().get(2).doOperation(), 0.001);
        Assert.assertTrue(calculator.getHistory().get(2) instanceof Division);

        Assert.assertEquals(15, calculator.getHistory().get(3).getFirstValue(), 0.001);
        Assert.assertEquals(10, calculator.getHistory().get(3).getSecondValue(), 0.001);
        Assert.assertEquals(150, calculator.getHistory().get(3).doOperation(), 0.001);
        Assert.assertTrue(calculator.getHistory().get(3) instanceof Multiply);

        Assert.assertEquals(2, calculator.getHistory().get(4).getFirstValue(), 0.001);
        Assert.assertEquals(6, calculator.getHistory().get(4).getSecondValue(), 0.001);
        Assert.assertEquals(64, calculator.getHistory().get(4).doOperation(), 0.001);
        Assert.assertTrue(calculator.getHistory().get(4) instanceof Pow);
    }
}
