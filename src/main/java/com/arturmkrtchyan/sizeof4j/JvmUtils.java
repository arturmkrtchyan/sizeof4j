package com.arturmkrtchyan.sizeof4j;


import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.text.DecimalFormat;

public class JvmUtils {

    private JvmUtils() {}

      //////////////////////////////////////////
     ///////////// VM Properties //////////////
    //////////////////////////////////////////

    public static final String vmName() {
        return System.getProperty("java.vm.name");
    }

    public static final String vmVersion() {
        return System.getProperty("java.vm.version");
    }

    public static final String vmSpecVersion() {
        return System.getProperty("java.vm.specification.version");
    }

    public static final String vmArch() {
        return System.getProperty("sun.arch.data.model");
    }


      ////////////////////////////////////////
     ///////////// JRE Properties ///////////
    ////////////////////////////////////////

    public static final String jreSpecVersion() {
        return System.getProperty("java.specification.version");
    }

    public static final String jreVersion() {
        return System.getProperty("java.version");
    }


      ////////////////////////////////////////
     ////////////// OS Properties ///////////
    ////////////////////////////////////////

    public static final String osArch() {
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
     * @return
     */
    public static final long initialMemory() {
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
    public static final long usedMemory() {
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
    public static final long committedMemory() {
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
     * @return
     */
    public static final long maxMemory() {
        long memory = 0;
        for (MemoryPoolMXBean mp : ManagementFactory.getMemoryPoolMXBeans()) {
            memory += mp.getUsage().getMax();
        }
        return memory;
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
        System.out.println("Initial Memory:       " + bytesToHuman(initialMemory()));
        System.out.println("Used Memory:          " + bytesToHuman(usedMemory()));
        System.out.println("Committed  Memory:    " + bytesToHuman(committedMemory()));
        System.out.println("Max Memory:           " + bytesToHuman(maxMemory()));

    }


    private static String floatForm(double d)
    {
        return new DecimalFormat("#.##").format(d);
    }


    private static String bytesToHuman(long size)
    {
        long Kb = 1  * 1024;
        long Mb = Kb * 1024;
        long Gb = Mb * 1024;
        long Tb = Gb * 1024;
        long Pb = Tb * 1024;
        long Eb = Pb * 1024;

        if (size <  Kb)                 return floatForm(        size     ) + " byte";
        if (size >= Kb && size < Mb)    return floatForm((double)size / Kb) + " Kb";
        if (size >= Mb && size < Gb)    return floatForm((double)size / Mb) + " Mb";
        if (size >= Gb && size < Tb)    return floatForm((double)size / Gb) + " Gb";
        if (size >= Tb && size < Pb)    return floatForm((double)size / Tb) + " Tb";
        if (size >= Pb && size < Eb)    return floatForm((double)size / Pb) + " Pb";
        if (size >= Eb)                 return floatForm((double)size / Eb) + " Eb";

        return "???";
    }

    // List of properties
   // http://docs.oracle.com/javase/6/docs/api/java/lang/System.html#getProperties%28%29

   // Memory Usage
  // http://docs.oracle.com/javase/7/docs/api/java/lang/management/MemoryUsage.html
}
