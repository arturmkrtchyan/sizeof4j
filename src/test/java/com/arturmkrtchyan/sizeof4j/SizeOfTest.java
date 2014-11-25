package com.arturmkrtchyan.sizeof4j;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SizeOfTest {

    @Test
    public void primitives() {
        assertEquals("booleanSize must be 1", 1, SizeOf.booleanSize());
        assertEquals("byteSize must be 1", 1, SizeOf.byteSize());
        assertEquals("shortSize must be 2", 2, SizeOf.shortSize());
        assertEquals("charSize must be 2", 2, SizeOf.charSize());
        assertEquals("intSize must be 4", 4, SizeOf.intSize());
        assertEquals("floatSize must be 4", 4, SizeOf.floatSize());
        assertEquals("longSize must be 8", 8, SizeOf.longSize());
        assertEquals("doubleSize must be 8", 8, SizeOf.doubleSize());
    }

    @Test
    public void objectShallowSize() {
        assertEquals("Object size must be 16", 16, SizeOf.shallowSize(new Object()));
    }



}