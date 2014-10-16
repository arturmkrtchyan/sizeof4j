package com.arturmkrtchyan.sizeof4j;


public class SizeOf {

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

    public static int objectSize(Object object) {
        // TODO implement
        return 0;
    }

    public static int objectSize() {
        return objectSize(new Object());
    }

    public static <T> int arraySize(T[] array) {
        // TODO implement
        return 0;
    }

    public static int arraySize(Object array) {
        // TODO implement
        return 0;
    }

}
