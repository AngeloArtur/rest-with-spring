package com.math.br.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MathController {
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(
            value = "numberOne") Double numberOne,
                      @PathVariable(value = "numberTwo") Double numberTwo) {
        return (numberOne + numberTwo);
    }
}
