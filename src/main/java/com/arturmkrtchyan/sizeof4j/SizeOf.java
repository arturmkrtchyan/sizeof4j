package com.arturmkrtchyan.sizeof4j;


public class SizeOf {

    public static int sizeOf(Object obj) {
        if(obj.getClass().isPrimitive()) {
            return Primitive.get(obj.getClass()).size();
        }
        return 0;
    }

    public static int sizeOf(boolean value) {
        return Primitive._boolean.size();
    }

    public static int sizeOf(byte value) {
        return Primitive._byte.size();
    }

    public static int sizeOf(char value) {
        return Primitive._char.size();
    }

    public static int sizeOf(short value) {
        return Primitive._short.size();
    }

    public static int sizeOf(int value) {
        return Primitive._int.size();
    }

    public static int sizeOf(float value) {
        return Primitive._float.size();
    }

    public static int sizeOf(long value) {
        return Primitive._long.size();
    }

    public static int sizeOf(double value) {
        return Primitive._double.size();
    }

}
