package com.arturmkrtchyan.sizeof4j.calculation;

public interface CalculationStrategy {

    public <T> int calculateShallow(final Class<T> clazz);

    /**
     * Calculates array shallow size.
     *
     * @param clazz array's class
     * @param length array's length
     * @param <T> type of array
     *
     * @return int shallow size of an array
     */
    public <T> int calculateShallow(final Class<T> clazz, final int length);

}
