package com.arturmkrtchyan.sizeof4j;

import org.junit.Test;

import static org.junit.Assert.*;

public class JvmUtilsTest {

    @Test
    public void testVmName() throws Exception {
        assertNotNull(JvmUtil.vmName());
        assertNotEquals(JvmUtil.vmName(), "");
    }

    @Test
    public void testVmVersion() throws Exception {
        assertNotNull(JvmUtil.vmVersion());
        assertNotEquals(JvmUtil.vmVersion(), "");
    }

    @Test
    public void testUnsafe() throws Exception {
        assertNotNull(JvmUtil.unsafe());
    }
}