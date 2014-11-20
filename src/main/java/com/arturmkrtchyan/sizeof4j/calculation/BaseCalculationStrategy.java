package com.arturmkrtchyan.sizeof4j.calculation;

import com.arturmkrtchyan.sizeof4j.Primitive;
import com.arturmkrtchyan.sizeof4j.layout.MemoryLayout;
import com.arturmkrtchyan.sizeof4j.util.JvmUtil;

public abstract class BaseCalculationStrategy implements CalculationStrategy {

    protected static final MemoryLayout memoryLayout = JvmUtil.memoryLayout();

    protected int roundToMultiple(final int value, final int multiple) {
        return ((value + multiple - 1) / multiple) * multiple;
    }

    @Override
    public <T> int calculateShallow(final Class<T> clazz, final int length) {
        Class arrayType = clazz.getComponentType();

        int size = memoryLayout.arrayHeaderSize();
        if(arrayType.isPrimitive()) {
            size += length * Primitive.get(arrayType).size();
        } else {
            size += length * memoryLayout.referenceSize();
        }
        return roundToMultiple(size, memoryLayout.objectPadding());
    }

}
