package com.arturmkrtchyan.sizeof4j.calculation;

public interface CalculationStrategy {

    public <T> int calculateShallow(Class<T> clazz);

}
