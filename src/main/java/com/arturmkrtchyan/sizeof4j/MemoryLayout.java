package com.arturmkrtchyan.sizeof4j;

public enum MemoryLayout {
    Layout32(12, 8, 8, 4, 4),
    Layout64(24, 16, 8, 8, 8),
    LayoutCoops(16, 12, 8, 4, 4);

    private int arrayHeaderSize;
    private int objectHeaderSize;
    private int objectPadding;
    private int referenceSize;
    private int superClassFieldPadding;

    MemoryLayout(int arrayHeaderSize,
                 int objectHeaderSize,
                 int objectPadding,
                 int referenceSize,
                 int superClassFieldPadding) {
        this.arrayHeaderSize = arrayHeaderSize;
        this.objectHeaderSize = objectHeaderSize;
        this.objectPadding = objectPadding;
        this.referenceSize = referenceSize;
        this.superClassFieldPadding = superClassFieldPadding;
    }

    public int arrayHeaderSize() {
        return arrayHeaderSize;
    }

    public int objectHeaderSize() {
        return objectHeaderSize;
    }

    public int objectPadding() {
        return objectPadding;
    }

    public int referenceSize() {
        return referenceSize;
    }

    public int superClassFieldPadding() {
        return superClassFieldPadding;
    }

}
