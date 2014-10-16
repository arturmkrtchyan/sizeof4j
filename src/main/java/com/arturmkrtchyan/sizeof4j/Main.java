package com.arturmkrtchyan.sizeof4j;


public class Main {

    public static void main(String[] args) {

        JvmUtils.printAll();

        System.out.println(SizeOf.byteSize());
        System.out.println(SizeOf.booleanSize());
        System.out.println(SizeOf.shortSize());
        System.out.println(SizeOf.charSize());
        System.out.println(SizeOf.intSize());
        System.out.println(SizeOf.floatSize());
        System.out.println(SizeOf.longSize());
        System.out.println(SizeOf.doubleSize());
        System.out.println(SizeOf.objectSize());

        System.out.println(SizeOf.objectSize(new Object()));
        System.out.println(SizeOf.arraySize(new Integer[] { 1 } ));
    }

}
