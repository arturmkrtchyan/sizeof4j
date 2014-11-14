package com.arturmkrtchyan.sizeof4j;


import com.arturmkrtchyan.sizeof4j.calculation.CalculationStrategy;
import com.arturmkrtchyan.sizeof4j.calculation.hotspot.HistogramCalculationStrategy;

public class SizeOf {


    private static final CalculationStrategy calculator = new HistogramCalculationStrategy();

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

    public static int objectShallowSize(Object object) {
        return objectShallowSize(object.getClass());
    }

    public static int objectShallowSize() {
        return objectShallowSize(new Object());
    }

    public static <T> int arrayShallowSize(T[] array) {
        return objectShallowSize(array.getClass());
    }

    public static int arrayShallowSize(Object array) {
        return objectShallowSize(array.getClass());
    }

    public static <T> int objectShallowSize(Class<T> clazz) {
        return calculator.calculateShallow(clazz);
    }

}
