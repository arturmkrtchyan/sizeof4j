package com.arturmkrtchyan.sizeof4j;

import com.arturmkrtchyan.sizeof4j.util.JvmUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SizeOfTest {

    MemoryLayout memoryLayout = JvmUtil.memoryLayout();

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
        final Object testObj = new Object();
        switch (memoryLayout) {
            case Layout32:
                assertEquals("Object size must be 8", 8,
                        SizeOf.shallowSize(testObj));
                break;
            case Layout64 :
                assertEquals("Object size must be 16", 16,
                        SizeOf.shallowSize(testObj));
                break;
            case LayoutCoops:
                assertEquals("Object size must be 16", 16,
                        SizeOf.shallowSize(testObj));
                break;
        }
    }

    @Test
    public void integerShallowSize() {
        final Integer testObj = new Integer(12);
        switch (memoryLayout) {
            case Layout32:
                assertEquals("Integer size must be 16", 16,
                        SizeOf.shallowSize(testObj));
                break;
            case Layout64 :
                assertEquals("Integer size must be 24", 24,
                        SizeOf.shallowSize(testObj));
                break;
            case LayoutCoops:
                assertEquals("Integer size must be 16", 16,
                        SizeOf.shallowSize(testObj));
                break;
        }
    }

    @Test
    public void stringShallowSize() {
        switch (memoryLayout) {
            case Layout32:
                assertEquals("String size must be 16", 16,
                        SizeOf.shallowSize(String.class));
                break;
            case Layout64 :
                assertEquals("String size must be 32", 32,
                        SizeOf.shallowSize(String.class));
                break;
            case LayoutCoops:
                assertEquals("String size must be 24", 24,
                        SizeOf.shallowSize(String.class));
                break;
        }
    }

    @Test
    public void emptyIntArrayShallowSize() {
        switch (memoryLayout) {
            case Layout32:
                assertEquals("int[] size must be 16", 16,
                        SizeOf.shallowSize(int[].class));
                break;
            case Layout64 :
                assertEquals("int[] size must be 24", 24,
                        SizeOf.shallowSize(int[].class));
                break;
            case LayoutCoops:
                assertEquals("int[] size must be 16", 16,
                        SizeOf.shallowSize(int[].class));
                break;
        }
    }

    @Test
    public void stringArrayShallowSize() {
        final String[] testObj = new String[] {"Hello", "World"};
        switch (memoryLayout) {
            case Layout32:
                assertEquals("String[2] size must be 24", 24,
                        SizeOf.shallowSize(testObj));
                break;
            case Layout64 :
                assertEquals("String[2] size must be 40", 40,
                        SizeOf.shallowSize(testObj));
                break;
            case LayoutCoops:
                assertEquals("String[2] size must be 24", 24,
                        SizeOf.shallowSize(testObj));
                break;
        }
    }



}