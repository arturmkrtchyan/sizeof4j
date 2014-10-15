package com.arturmkrtchyan.sizeof4j;


public class Main {

    public static void main(String[] args) {

        //JvmUtils.printAll();

        System.out.println(SizeOf.sizeOf((byte)1));
        System.out.println(SizeOf.sizeOf(false));
        System.out.println(SizeOf.sizeOf((short)2));
        System.out.println(SizeOf.sizeOf((char)3));
        System.out.println(SizeOf.sizeOf(3));
        System.out.println(SizeOf.sizeOf(3.0F));
        System.out.println(SizeOf.sizeOf(100L));
        System.out.println(SizeOf.sizeOf(4.0D));
    }

}
