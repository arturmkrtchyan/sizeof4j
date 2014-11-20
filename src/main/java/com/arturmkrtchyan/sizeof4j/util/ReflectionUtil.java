package com.arturmkrtchyan.sizeof4j.util;

import com.arturmkrtchyan.sizeof4j.Primitive;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtil {

    public static <T> T newInstance(final Class<T> clazz) {
        final Constructor<T> constructor = getConstructor(clazz);
        constructor.setAccessible(true);
        final Object[] parameters = getParameterValues(constructor);
        return newInstance(constructor, parameters);
    }

    public static <T> boolean isPrimitiveArray(final T object) {
        return object.getClass().isArray() &&
                object.getClass().getComponentType().isPrimitive();
    }

    public static <T> int getArrayLength(final T object) {
        return Array.getLength(object);
    }

    @SuppressWarnings("unchecked")
    static <T> Constructor<T> getConstructor(final Class<T> clazz) {
        final Constructor[] constructors = clazz.getDeclaredConstructors();

        for(final Constructor constructor: constructors) {
            if(constructor.getGenericParameterTypes().length == 0) {
                return constructor;
            }
        }
        return constructors[0];
    }

    static boolean hasParameters(final Constructor constructor) {
        return constructor.getGenericParameterTypes().length != 0;
    }

    static <T> T newInstance(final Constructor<T> constructor, final Object ... args) {
        try {
            return constructor.newInstance(args);
        } catch (InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    static Object[] getParameterValues(final Constructor constructor) {
        final Class[] parameterTypes = constructor.getParameterTypes();
        final List parameters = new ArrayList(parameterTypes.length);

        for(final Class type : parameterTypes) {
            if(type.isPrimitive()) {
                parameters.add(Primitive.get(type).defaultValue());
            } else {
                parameters.add(null);
            }
        }
        return parameters.toArray();
    }

}
