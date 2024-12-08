package com.demolearn.LearnSpringBoot;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int calculatorSum(int a, int b)
    {
        return a + b;
    }
}
