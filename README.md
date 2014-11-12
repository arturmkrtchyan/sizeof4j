sizeof4j
========

[![Build Status](https://api.travis-ci.org/repositories/arturmkrtchyan/sizeof4j.png)](https://travis-ci.org/arturmkrtchyan/sizeof4j)

A Java library for measuring memory size of Java objects.

```java
public class Main {

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
        System.out.println("Object:     " + SizeOf.objectShallowSize(new Object()));
        System.out.println("Integer:    " + SizeOf.objectShallowSize(new Integer(2)));
        System.out.println("String:     " + SizeOf.objectShallowSize(new String("aaa")));

        System.out.println("--------------------------");
        System.out.println("A:          " + SizeOf.objectShallowSize(new A()));
        System.out.println("B:          " + SizeOf.objectShallowSize(new B()));
        System.out.println("C:          " + SizeOf.objectShallowSize(new C()));
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
