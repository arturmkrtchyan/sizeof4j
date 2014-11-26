package com.arturmkrtchyan.sizeof4j.util;

import java.text.DecimalFormat;

public class ConsoleUtil {

    public static void printJvmDetails() {
        System.out.println("\nVM Information ");
        System.out.println("=============================================");
        System.out.println("VM Name:            " + JvmUtil.vmName());
        System.out.println("VM Version:         " + JvmUtil.vmVersion());
        System.out.println("VM Spec Version:    " + JvmUtil.vmSpecVersion());
        System.out.println("VM Arch:            " + JvmUtil.vmArch());

        System.out.println("\n\nJRE Information ");
        System.out.println("=============================================");
        System.out.println("JRE Version:        " + JvmUtil.jreVersion());
        System.out.println("JRE Spec Version:   " + JvmUtil.jreSpecVersion());

        System.out.println("\n\nOS Information ");
        System.out.println("=============================================");
        System.out.println("OS Architecture:    " + JvmUtil.osArch());

        System.out.println("\n\nMemory Information");
        System.out.println("=============================================");
        System.out.println("Initial Memory:       " + printableBytes(JvmUtil.initialMemory()));
        System.out.println("Used Memory:          " + printableBytes(JvmUtil.usedMemory()));
        System.out.println("Committed  Memory:    " + printableBytes(JvmUtil.committedMemory()));
        System.out.println("Max Memory:           " + printableBytes(JvmUtil.maxMemory()));

    }


    private static String printableBytes(long size) {
        long K = 1  * 1024;
        long M = K * 1024;
        long G = M * 1024;
        long T = G * 1024;

        if (size <  K)                return format(size) + " Byte";
        if (size >= K && size < M)    return format((double) size / K) + " KB";
        if (size >= M && size < G)    return format((double) size / M) + " MB";
        if (size >= G && size < T)    return format((double) size / G) + " GB";
        if (size >= T)                return format((double) size / T) + " TB";

        return "";
    }

    private static String format(double d) {
        return new DecimalFormat("#.##").format(d);
    }

}
