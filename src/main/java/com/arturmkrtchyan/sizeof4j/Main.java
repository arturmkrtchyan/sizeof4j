package com.arturmkrtchyan.sizeof4j;

import com.arturmkrtchyan.sizeof4j.util.JvmUtil;

class Main {

    public static void main(String[] args) {

        JvmUtil.printAll();

        System.out.println("\n\nSizeOf");
        System.out.println("=================================");

        System.out.println(" --------------------------");
        System.out.println("|       Primitives         |");
        System.out.println(" --------------------------");
        System.out.println("byte:       " + SizeOf.byteSize());
        System.out.println("boolean:    " + SizeOf.booleanSize());
        System.out.println("short:      " + SizeOf.shortSize());
        System.out.println("char:       " + SizeOf.charSize());
        System.out.println("int:        " + SizeOf.intSize());
        System.out.println("float:      " + SizeOf.floatSize());
        System.out.println("long:       " + SizeOf.longSize());
        System.out.println("double:     " + SizeOf.doubleSize());

        System.out.println(" --------------------------");
        System.out.println("|     Classic Objects      |");
        System.out.println(" --------------------------");
        System.out.println("Object:     " + SizeOf.shallowSize(Object.class));
        System.out.println("Integer:    " + SizeOf.shallowSize(new Integer(2)));
        System.out.println("String:     " + SizeOf.shallowSize(new String("aaa")));

        System.out.println(" --------------------------");
        System.out.println("|      Custom Objects      |");
        System.out.println(" --------------------------");
        System.out.println("A:          " + SizeOf.shallowSize(new A()));
        System.out.println("B:          " + SizeOf.shallowSize(new B()));
        System.out.println("C:          " + SizeOf.shallowSize(new C()));


        System.out.println(" --------------------------");
        System.out.println("|      Class Objects      |");
        System.out.println(" --------------------------");
        System.out.println("int.class:  " + SizeOf.shallowSize(int.class));
        System.out.println("D.class:    " + SizeOf.shallowSize(D.class));

        System.out.println(" --------------------------");
        System.out.println("|           Arrays         |");
        System.out.println(" --------------------------");
        System.out.println("int[]:      " + SizeOf.shallowSize(new int[]{}));
        System.out.println("int[2]:      " + SizeOf.shallowSize(new int[]{1, 2}));
        System.out.println("int[].class " + SizeOf.shallowSize(int[].class));
        System.out.println("C[].class   " + SizeOf.shallowSize(C[].class));
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

    private static class D {
        private int i;
        private java.util.HashMap hm = new java.util.HashMap();
    }

}
