package com.arturmkrtchyan.sizeof4j.layout;

public class MemoryLayout32 implements MemoryLayout {

    @Override public int arrayHeaderSize() {
        return 12;
    }

    @Override public int objectHeaderSize() {
        return 8;
    }

    @Override public int objectPadding() {
        return 8;
    }

    @Override public int referenceSize() {
        return 4;
    }

    @Override public int superClassFieldPadding() {
        return 4;
    }

}
