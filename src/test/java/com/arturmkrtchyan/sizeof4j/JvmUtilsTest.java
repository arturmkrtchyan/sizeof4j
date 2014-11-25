package com.arturmkrtchyan.sizeof4j;

import com.arturmkrtchyan.sizeof4j.util.JvmUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class JvmUtilsTest {

    @Test
    public void vmName() {
        assertNotNull(JvmUtil.vmName());
        assertNotEquals(JvmUtil.vmName(), "");
    }

    @Test
    public void vmVersion() {
        assertNotNull(JvmUtil.vmVersion());
        assertNotEquals(JvmUtil.vmVersion(), "");
    }

    @Test
    public void unsafe() {
        assertNotNull(JvmUtil.unsafe());
    }
}