package com.demolearn.LearnSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@Profile("prod")
public class MySimpleController {

    private final Calculator calculator;
    public MySimpleController(Calculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping(value = {"home"},method = {RequestMethod.GET,RequestMethod.POST})
    public String home(){
        return "Hello World";
}
    @GetMapping("/demo")
    public String demo(){
        return "Hello From demo!!!";
    }

    @GetMapping("/sum")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b)
    {
        return calculator.calculatorSum(a,b);
    }
}
