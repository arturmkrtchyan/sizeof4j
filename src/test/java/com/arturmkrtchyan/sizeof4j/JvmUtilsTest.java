package com.arturmkrtchyan.sizeof4j;

import org.junit.Test;

import static org.junit.Assert.*;

public class JvmUtilsTest {

    @Test
    public void testVmName() throws Exception {
        assertNotNull(JvmUtils.vmName());
        assertNotEquals(JvmUtils.vmName(), "");
    }

    @Test
    public void testVmVersion() throws Exception {
        assertNotNull(JvmUtils.vmVersion());
        assertNotEquals(JvmUtils.vmVersion(), "");
    }

    @Test
    public void testUnsafe() throws Exception {
        assertNotNull(JvmUtils.unsafe());
    }
}