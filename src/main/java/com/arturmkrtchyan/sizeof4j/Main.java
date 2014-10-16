package com.arturmkrtchyan.sizeof4j;


import com.arturmkrtchyan.sizeof4j.test.A;
import com.arturmkrtchyan.sizeof4j.test.B;
import com.arturmkrtchyan.sizeof4j.test.C;

public class Main {

    public static void main(String[] args) {

        JvmUtil.printAll();

        System.out.println(SizeOf.byteSize());
        System.out.println(SizeOf.booleanSize());
        System.out.println(SizeOf.shortSize());
        System.out.println(SizeOf.charSize());
        System.out.println(SizeOf.intSize());
        System.out.println(SizeOf.floatSize());
        System.out.println(SizeOf.longSize());
        System.out.println(SizeOf.doubleSize());

        System.out.println(SizeOf.objectShallowSize(new Object()));
        System.out.println(SizeOf.objectShallowSize(new Integer(2)));

        System.out.println(SizeOf.objectShallowSize(new A()));
        System.out.println(SizeOf.objectShallowSize(new B()));
        System.out.println(SizeOf.objectShallowSize(new C()));
    }

}
