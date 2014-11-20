package com.arturmkrtchyan.sizeof4j.calculation.hotspot;

import com.arturmkrtchyan.sizeof4j.calculation.BaseCalculationStrategy;
import com.arturmkrtchyan.sizeof4j.util.ReflectionUtil;

import java.util.Map;

public class HistogramCalculationStrategy extends BaseCalculationStrategy {

    private static volatile Object instance;

    @Override
    public <T> int calculateShallow(final Class<T> clazz) {
        instance = ReflectionUtil.newInstance(clazz);
        final Map<String, HistogramEntry> entries = HotSpotHistogram.heapHistogram();
        final HistogramEntry entry = entries.get(clazz.getName());
        return entry.bytes/entry.count;
    }
}