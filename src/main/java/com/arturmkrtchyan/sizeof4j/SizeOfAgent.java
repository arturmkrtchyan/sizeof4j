package com.arturmkrtchyan.sizeof4j;

import static java.lang.System.out;

import java.lang.instrument.Instrumentation;

class SizeOfAgent {

    /** Handle to instance of Instrumentation interface. */
    private static volatile Instrumentation instrumentation;

    /**
     * Implementation of the overloaded premain method that is first invoked by
     * the JVM during use of instrumentation.
     *
     * @param agentArgs Agent options provided as a single String.
     * @param inst Handle to instance of Instrumentation provided on command-line.
     */
    public static void premain(final String agentArgs, final Instrumentation inst) {
        out.println("premain...");
        instrumentation = inst;
    }

    /**
     * Implementation of the overloaded agentmain method that is invoked for
     * accessing instrumentation of an already running JVM.
     *
     * @param agentArgs Agent options provided as a single String.
     * @param inst Handle to instance of Instrumentation provided on command-line.
     */
    public static void agentmain(String agentArgs, Instrumentation inst) {
        out.println("agentmain...");
        instrumentation = inst;
    }

    /**
     * Provide the memory size of the provided object (but not it's components).
     *
     * @param object Object whose memory size is desired.
     * @return The size of the provided object, not counting its components
     *    (described in Instrumentation.getObjectSize(Object)'s Javadoc as "an
     *    implementation-specific approximation of the amount of storage consumed
     *    by the specified object").
     * @throws IllegalStateException Thrown if my Instrumentation is null.
     */
    public static long getObjectSize(final Object object) {
        if (instrumentation == null) {
            throw new IllegalStateException("Agent not initialized.");
        }
        return instrumentation.getObjectSize(object);
    }

}
