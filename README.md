sizeof4j
========

[![Build Status](https://api.travis-ci.org/repositories/arturmkrtchyan/sizeof4j.png)](https://travis-ci.org/arturmkrtchyan/sizeof4j) [![License](http://img.shields.io/:license-Apache 2.0-blue.svg)](https://raw.githubusercontent.com/arturmkrtchyan/iban4j/master/LICENSE.txt)

A Java library for measuring memory size of Java objects.

```java
class Main {

    public static void main(String[] args) {

        JvmUtil.printAll();

        System.out.println("\n\nSizeOf");
        System.out.println("=================================");
        System.out.println("byte:       " + SizeOf.byteSize());
        System.out.println("boolean:    " + SizeOf.booleanSize());
        System.out.println("short:      " + SizeOf.shortSize());
        System.out.println("char:       " + SizeOf.charSize());
        System.out.println("int:        " + SizeOf.intSize());
        System.out.println("float:      " + SizeOf.floatSize());
        System.out.println("long:       " + SizeOf.longSize());
        System.out.println("double:     " + SizeOf.doubleSize());

        System.out.println("--------------------------");
        System.out.println("Object:     " + SizeOf.shallowSize(Object.class));
        System.out.println("Integer:    " + SizeOf.shallowSize(new Integer(2)));
        System.out.println("String:     " + SizeOf.shallowSize(new String("aaa")));

        System.out.println("--------------------------");
        System.out.println("A:          " + SizeOf.shallowSize(new A()));
        System.out.println("B:          " + SizeOf.shallowSize(new B()));
        System.out.println("C:          " + SizeOf.shallowSize(new C()));
        System.out.println("C[2]:       " + SizeOf.shallowSize(new C[]{new C(), new C()}));
    }

    private static class A {
        private int i;
    }

    private static class B {
        private int i;
        private java.util.Locale l = java.util.Locale.US;
    }

    private static class C {
        private int i;
        private java.util.HashMap hm = new java.util.HashMap();
    }

}
```

![Compatibility Badge](https://java.net/downloads/adoptopenjdk/compat.svg)

