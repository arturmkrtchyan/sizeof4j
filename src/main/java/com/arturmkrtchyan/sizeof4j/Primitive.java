package com.arturmkrtchyan.sizeof4j;


public enum Primitive {

    _boolean(1, boolean.class),
    _byte(1, byte.class),
    _short(2, short.class),
    _char(2, char.class),
    _int(4, int.class),
    _float(4, float.class),
    _long(8, long.class),
    _double(8, double.class);

    private final int size;
    private final Class<?> type;

    Primitive(final int size, final Class<?> type) {
        this.size = size;
        this.type = type;
    }

    public int size() {
        return size;
    }

    public Class<?> type() {
        return type;
    }

    public static Primitive get(Class<?> type) {
        for(Primitive primitive : values()) {
            if(type == primitive.type) {
                return primitive;
            }
        }
        return null;
    }

}
