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

    @Test
    public void committedMemory() {
        final long memory = JvmUtil.committedMemory();
        assertTrue(memory > 0);
    }

    @Test
    public void initialMemory() {
        final long memory = JvmUtil.initialMemory();
        assertTrue(memory > 0);
    }

    @Test
    public void maxMemory() {
        final long memory = JvmUtil.maxMemory();
        assertTrue(memory > 0);
    }

    @Test
    public void usedMemory() {
        final long memory = JvmUtil.usedMemory();
        assertTrue(memory > 0);
    }

    @Test
    public void jreSpecVersion() {
        assertNotNull(JvmUtil.jreSpecVersion());
        assertNotEquals(JvmUtil.jreSpecVersion(), "");
    }

    @Test
    public void jreVersion() {
        assertNotNull(JvmUtil.jreVersion());
        assertNotEquals(JvmUtil.jreVersion(), "");
    }

    @Test
    public void osArch() {
        assertNotNull(JvmUtil.osArch());
        assertNotEquals(JvmUtil.osArch(), "");
    }

    @Test
    public void vmArch() {
        assertNotNull(JvmUtil.vmArch());
        assertNotEquals(JvmUtil.vmArch(), "");
    }

    @Test
    public void vmSpecVersion() {
        assertNotNull(JvmUtil.vmSpecVersion());
        assertNotEquals(JvmUtil.vmSpecVersion(), "");
    }

    @Test
    public void processId() {
        assertNotNull(JvmUtil.processId());
        assertNotEquals(JvmUtil.processId(), "");
    }

    @Test
    public void memoryLayout() {
        assertNotNull(JvmUtil.memoryLayout());
    }
}