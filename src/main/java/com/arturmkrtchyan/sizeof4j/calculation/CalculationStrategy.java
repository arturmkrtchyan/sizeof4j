package com.arturmkrtchyan.sizeof4j.calculation;

public interface CalculationStrategy {

    public <T> int calculateShallow(Class<T> clazz);

    public <T> int calculateShallow(T[] array);

    public <T> int calculateArrayShallow(Class<T> clazz);

}
