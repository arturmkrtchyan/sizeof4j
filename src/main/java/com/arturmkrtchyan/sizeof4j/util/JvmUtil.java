package com.arturmkrtchyan.sizeof4j.util;


import com.arturmkrtchyan.sizeof4j.MemoryLayout;
import sun.misc.Unsafe;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.reflect.Field;
import java.text.DecimalFormat;

public class JvmUtil {

    private static final String ARCH_32 = "32";
    private static final String ARCH_64 = "64";

    private static final long HEAP_30GB = 30L * 1024 * 1024 * 1024;

    private static Unsafe unsafe;

    private JvmUtil() {}

      //////////////////////////////////////////
     ///////////// VM Properties //////////////
    //////////////////////////////////////////

    public static String vmName() {
        return System.getProperty("java.vm.name");
    }

    public static String vmVersion() {
        return System.getProperty("java.vm.version");
    }

    public static String vmSpecVersion() {
        return System.getProperty("java.vm.specification.version");
    }

    public static String vmArch() {
        return System.getProperty("sun.arch.data.model");
    }


      ////////////////////////////////////////
     ///////////// JRE Properties ///////////
    ////////////////////////////////////////

    public static String jreSpecVersion() {
        return System.getProperty("java.specification.version");
    }

    public static String jreVersion() {
        return System.getProperty("java.version");
    }


      ////////////////////////////////////////
     ////////////// OS Properties ///////////
    ////////////////////////////////////////

    public static String osArch() {
        return System.getProperty("os.arch");
    }

    ////////////////////////////////////////
    ////////////// Memory Usage ///////////
    //////////////////////////////////////

    /**
     * Represents the initial amount of memory (in bytes) that the Java virtual machine requests from
     * the operating system for memory management during startup.
     * The Java virtual machine may request additional memory from the operating system and may also
     * release memory to the system over time.
     * The value of init may be undefined.
     *
     * @return memory
     */
    public static long initialMemory() {
        long memory = 0;
        for (MemoryPoolMXBean mp : ManagementFactory.getMemoryPoolMXBeans()) {
            memory += mp.getUsage().getInit();
        }
        return memory;
    }

    /**
     * Represents the amount of memory currently used (in bytes).
     *
     * @return memory
     */
    public static long usedMemory() {
        long memory = 0;
        for (MemoryPoolMXBean mp : ManagementFactory.getMemoryPoolMXBeans()) {
            memory += mp.getUsage().getUsed();
        }
        return memory;
    }

    /**
     * Represents the amount of memory (in bytes) that is guaranteed to be available for use by the Java virtual machine.
     * The amount of committed memory may change over time (increase or decrease).
     *
     * @return memory
     */
    public static long committedMemory() {
        long memory = 0;
        for (MemoryPoolMXBean mp : ManagementFactory.getMemoryPoolMXBeans()) {
            memory += mp.getUsage().getUsed();
        }
        return memory;
    }

    /**
     * Represents the maximum amount of memory (in bytes) that can be used for memory management.
     * Its value may be undefined. The maximum amount of memory may change over time if defined.
     * The amount of used and committed memory will always be less than or equal to max if max is defined.
     *
     * @return memory
     */
    public static long maxMemory() {
        long memory = 0;
        for (MemoryPoolMXBean mp : ManagementFactory.getMemoryPoolMXBeans()) {
            memory += mp.getUsage().getMax();
        }
        return memory;
    }

    public static String processId() {
        String runtimeName = ManagementFactory.getRuntimeMXBean().getName();
        return runtimeName.split("@")[0];
    }

    public static synchronized Unsafe unsafe() {
        if(unsafe == null) {
            try {
                Field field = Unsafe.class.getDeclaredField("theUnsafe");
                field.setAccessible(true);
                unsafe = (Unsafe) field.get(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return unsafe;
    }

    public static MemoryLayout memoryLayout() {
        final String vmArch = vmArch();

        if(ARCH_32.equals(vmArch)) {
            return MemoryLayout.Layout32;
        } else if(ARCH_64.equals(vmArch)) {
            if(maxMemory() < HEAP_30GB) {
                return MemoryLayout.LayoutCoops;
            }
            return MemoryLayout.Layout64;
        }
        return null;
    }

    public static void printAll() {
        System.out.println("\nVM Information ");
        System.out.println("=============================================");
        System.out.println("VM Name:            " + vmName());
        System.out.println("VM Version:         " + vmVersion());
        System.out.println("VM Spec Version:    " + vmSpecVersion());
        System.out.println("VM Arch:            " + vmArch());

        System.out.println("\n\nJRE Information ");
        System.out.println("=============================================");
        System.out.println("JRE Version:        " + jreVersion());
        System.out.println("JRE Spec Version:   " + jreSpecVersion());

        System.out.println("\n\nOS Information ");
        System.out.println("=============================================");
        System.out.println("OS Architecture:    " + osArch());

        System.out.println("\n\nMemory Information");
        System.out.println("=============================================");
        System.out.println("Initial Memory:       " + printableBytes(initialMemory()));
        System.out.println("Used Memory:          " + printableBytes(usedMemory()));
        System.out.println("Committed  Memory:    " + printableBytes(committedMemory()));
        System.out.println("Max Memory:           " + printableBytes(maxMemory()));

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

    // List of properties
   // http://docs.oracle.com/javase/6/docs/api/java/lang/System.html#getProperties%28%29

   // Memory Usage
  // http://docs.oracle.com/javase/7/docs/api/java/lang/management/MemoryUsage.html
}
