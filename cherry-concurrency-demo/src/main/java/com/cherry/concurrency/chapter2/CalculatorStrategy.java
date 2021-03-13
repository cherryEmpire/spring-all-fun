package com.cherry.concurrency.chapter2;

@FunctionalInterface
public interface CalculatorStrategy {

    double calculate(double salary, double bonus);
}
