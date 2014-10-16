package com.arturmkrtchyan.sizeof4j;

public interface MemoryLayout {

    int arrayHeaderSize();

    int objectHeaderSize();

    int objectPadding();

    int referenceSize();

    int superClassFieldPadding();

}
