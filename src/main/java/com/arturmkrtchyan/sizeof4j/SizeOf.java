package com.arturmkrtchyan.sizeof4j;


import com.arturmkrtchyan.sizeof4j.calculation.CalculationStrategy;
import com.arturmkrtchyan.sizeof4j.calculation.hotspot.HistogramCalculationStrategy;

public class SizeOf {


    private static final CalculationStrategy histoCalculator = new HistogramCalculationStrategy();

    private static final CalculationStrategy specCalculator = new HistogramCalculationStrategy();

    public static int booleanSize() {
        return Primitive._boolean.size();
    }

    public static int byteSize() {
        return Primitive._byte.size();
    }

    public static int charSize() {
        return Primitive._char.size();
    }

    public static int shortSize() {
        return Primitive._short.size();
    }

    public static int intSize() {
        return Primitive._int.size();
    }

    public static int floatSize() {
        return Primitive._float.size();
    }

    public static int longSize() {
        return Primitive._long.size();
    }

    public static int doubleSize() {
        return Primitive._double.size();
    }

    public static <T> int shallowSize(final T[] array) {
        return shallowSize(array.getClass());
    }

    public static <T> int shallowSize(final T object) {
        return shallowSize(object.getClass());
    }

    public static <T> int shallowSize(final Class<T> clazz) {
        if(clazz.isPrimitive()) {
            return Primitive.get(clazz).size();
        }
        return histoCalculator.calculateShallow(clazz);
    }

}
