package com.arturmkrtchyan.sizeof4j;


public enum Primitive {

    _boolean(1, boolean.class, false),
    _byte(1, byte.class, (byte)0),
    _short(2, short.class, (short)0),
    _char(2, char.class, (char)0),
    _int(4, int.class, 0),
    _float(4, float.class, (float)0),
    _long(8, long.class, (long)0),
    _double(8, double.class, (double)0);

    private final int size;
    private final Class<?> type;
    private final Object defaultValue;

    Primitive(final int size, final Class<?> type, Object defaultValue) {
        this.size = size;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public int size() {
        return size;
    }

    public Object defaultValue() {
        return defaultValue;
    }

    public static Primitive get(final Class<?> type) {
        for(Primitive primitive : values()) {
            if(type == primitive.type) {
                return primitive;
            }
        }
        return null;
    }

}
