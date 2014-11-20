package com.arturmkrtchyan.sizeof4j.calculation;

import com.arturmkrtchyan.sizeof4j.Primitive;
import com.arturmkrtchyan.sizeof4j.layout.MemoryLayout;
import com.arturmkrtchyan.sizeof4j.util.JvmUtil;

public abstract class BaseCalculationStrategy implements CalculationStrategy {

    protected static final MemoryLayout memoryLayout = JvmUtil.memoryLayout();

    protected int roundToMultiple(int value, int multiple) {
        return ((value + multiple - 1) / multiple) * multiple;
    }

    @Override
    public <T> int calculateShallow(final T[] array) {
        Class arrayType = array.getClass().getComponentType();

        int size = memoryLayout.arrayHeaderSize();
        if(arrayType.isPrimitive()) {
            size += array.length * Primitive.get(arrayType).size();
        } else {
            size += array.length * memoryLayout.referenceSize();
        }
        // FIXME padding
        return size;
    }

    @Override
    public <T> int calculateArrayShallow(final Class<T> clazz) {
        final int arrayHeaderSize = memoryLayout.arrayHeaderSize();
        return roundToMultiple(arrayHeaderSize, memoryLayout.objectPadding());
    }

}
