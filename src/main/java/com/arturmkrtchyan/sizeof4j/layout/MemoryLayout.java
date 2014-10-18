package com.arturmkrtchyan.sizeof4j.layout;

public interface MemoryLayout {

    int arrayHeaderSize();

    int objectHeaderSize();

    int objectPadding();

    int referenceSize();

    int superClassFieldPadding();

}
