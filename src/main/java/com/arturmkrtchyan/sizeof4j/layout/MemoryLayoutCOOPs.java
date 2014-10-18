package com.arturmkrtchyan.sizeof4j.layout;

public class MemoryLayoutCOOPs implements MemoryLayout {

    @Override public int arrayHeaderSize() {
        return 16;
    }

    @Override public int objectHeaderSize() {
        return 12;
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
