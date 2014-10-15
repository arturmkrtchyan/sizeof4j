package com.arturmkrtchyan.sizeof4j;

public abstract class MemoryLayout {

    public abstract int arrayHeaderSize();

    public abstract int objectHeaderSize();

    public abstract int objectPadding();

    public abstract int referenceSize();

    public abstract int superClassFieldPadding();

}
