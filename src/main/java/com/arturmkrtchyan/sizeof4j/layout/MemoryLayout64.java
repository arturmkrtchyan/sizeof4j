package com.arturmkrtchyan.sizeof4j.layout;

public class MemoryLayout64 implements MemoryLayout {

    @Override public int arrayHeaderSize() {
        return 24;
    }

    @Override public int objectHeaderSize() {
        return 16;
    }

    @Override public int objectPadding() {
        return 8;
    }

    @Override public int referenceSize() {
        return 8;
    }

    @Override public int superClassFieldPadding() {
        return 8;
    }

}
