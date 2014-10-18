package com.arturmkrtchyan.sizeof4j.calculation;

import com.arturmkrtchyan.sizeof4j.JvmUtil;
import com.arturmkrtchyan.sizeof4j.layout.MemoryLayout;
import com.arturmkrtchyan.sizeof4j.Primitive;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class SpecCalculationStrategy implements CalculationStrategy {

    private MemoryLayout memoryLayout = JvmUtil.memoryLayout();

    @Override
    public int calculateShallow(final Object obj) {
        final Class<?> type = obj.getClass();
        if (type.isArray()) {
            return 0;
        }
        return calculateShallow(type);
    }

    protected int calculateShallow(Class<?> type) {
        int size = memoryLayout.objectHeaderSize() + calculateDeclaredFields(type);
        return roundToMultiple(size, memoryLayout.objectPadding());
    }

    private int calculateDeclaredFields(Class<?> type) {
        int size = 0;
        for (Field f : fieldsOf(type)) {
            if(f.getType().isPrimitive()) {
                size += Primitive.get(f.getType()).size();
            } else {
                size += memoryLayout.referenceSize();
            }
        }
        return size;
    }

    private Iterable<Field> fieldsOf(Class<?> type) {
        List<Field> fields = new ArrayList<Field>();
        for (Field f : type.getDeclaredFields()) {
            // exclude static fields
            if (!Modifier.isStatic(f.getModifiers())) {
                fields.add(f);
            }
        }
        return fields;
    }

    private int roundToMultiple(int value, int multiple) {
        return ((value + multiple - 1) / multiple) * multiple;
    }

}
