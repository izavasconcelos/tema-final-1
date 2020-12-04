package com.izavasconcelos.cloud.tema04.sevlet;

import com.izavasconcelos.cloud.tema04.annotation.AppConfig;
import com.izavasconcelos.cloud.tema04.exceptions.InvalidOperationException;
import com.izavasconcelos.cloud.tema04.service.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/")
public class CalculatorServlet extends HttpServlet {

    private ApplicationContext applicationContext;
    private Calculator calculator;

    public CalculatorServlet() {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        calculator = applicationContext.getBean("calculator", Calculator.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();

        printWriter.println("Calculadora Spring com JETTY");
        printWriter.println("\nInsira os valores em X, Y e Z: localhost:8080/calculator?num1=[X]&op=[Y]&num2=[Z]\n");

        Map<String, String[]> requestParameters = request.getParameterMap();
        if(requestParameters.containsKey("num1") && requestParameters.containsKey("num2") && requestParameters.containsKey("op")) {

            try {
                double firstValue = Double.parseDouble(request.getParameter("num1"));
                double secondValue = Double.parseDouble(request.getParameter("num2"));

                String operation = request.getParameter("op");
                double result = calculator.doOperation(firstValue, operation, secondValue);
                printWriter.println("Result: " + firstValue + " " + operation + " " + secondValue + " = " + result);

            } catch (NumberFormatException e) {
                printWriter.println("Número Inválido!!! Tente novamente!");
            } catch (InvalidOperationException e) {
                printWriter.println("Operação Inválida!!! Tente novamente!");
            }

        }
        else if(requestParameters.containsKey("history")){
            printWriter.println("--------- History Operations ----------");
            printWriter.println(calculator.getHistory());
        }
        printWriter.close();
    }
}

