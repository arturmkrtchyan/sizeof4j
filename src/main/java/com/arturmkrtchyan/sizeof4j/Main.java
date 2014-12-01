package com.arturmkrtchyan.sizeof4j;

import com.arturmkrtchyan.sizeof4j.util.ConsoleUtil;

import static java.lang.System.out;

class Main {

    public static void main(String[] args) {

        ConsoleUtil.printJvmDetails();

        out.println("\n\nSizeOf");
        out.println("=================================");

        out.println(" --------------------------");
        out.println("|       Primitives         |");
        out.println(" --------------------------");
        out.println("byte:       " + SizeOf.byteSize());
        out.println("boolean:    " + SizeOf.booleanSize());
        out.println("short:      " + SizeOf.shortSize());
        out.println("char:       " + SizeOf.charSize());
        out.println("int:        " + SizeOf.intSize());
        out.println("float:      " + SizeOf.floatSize());
        out.println("long:       " + SizeOf.longSize());
        out.println("double:     " + SizeOf.doubleSize());

        out.println(" --------------------------");
        out.println("|     Classic Objects      |");
        out.println(" --------------------------");
        out.println("Object:     " + SizeOf.shallowSize(Object.class));
        out.println("Integer:    " + SizeOf.shallowSize(new Integer(2)));
        out.println("String:     " + SizeOf.shallowSize(new String("aaa")));

        out.println(" --------------------------");
        out.println("|      Custom Objects      |");
        out.println(" --------------------------");
        out.println("A:          " + SizeOf.shallowSize(new A()));
        out.println("B:          " + SizeOf.shallowSize(new B()));
        out.println("C:          " + SizeOf.shallowSize(new C()));


        out.println(" --------------------------");
        out.println("|      Class Objects      |");
        out.println(" --------------------------");
        out.println("int.class:  " + SizeOf.shallowSize(int.class));
        out.println("D.class:    " + SizeOf.shallowSize(D.class));

        out.println(" --------------------------");
        out.println("|           Arrays         |");
        out.println(" --------------------------");
        out.println("int[]:      " + SizeOf.shallowSize(new int[]{}));
        out.println("int[2]:      " + SizeOf.shallowSize(new int[]{1, 2}));
        out.println("int[].class " + SizeOf.shallowSize(int[].class));
        out.println("C[].class   " + SizeOf.shallowSize(C[].class));
        out.println("C[2]:       " + SizeOf.shallowSize(new C[]{new C(), new C()}));
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
