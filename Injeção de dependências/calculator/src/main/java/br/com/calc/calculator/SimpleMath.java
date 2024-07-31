package br.com.calc.calculator;

import br.com.calc.calculator.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static br.com.calc.calculator.converters.NumberConverter.convertToDouble;
import static br.com.calc.calculator.converters.NumberConverter.isNumeric;

public class SimpleMath {
    public Double sum( Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double sub(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }


    public Double multi(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }


    public Double div(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }


    public Double mean(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo)/2;
    }

    public Double square(Double numberOne) {
        return Math.sqrt(numberOne);
    }
}
