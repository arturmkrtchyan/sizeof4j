package com.arturmkrtchyan.sizeof4j.calculation.hotspot;

import com.arturmkrtchyan.sizeof4j.calculation.CalculationStrategy;

import java.util.Map;

public class HistogramCalculationStrategy implements CalculationStrategy {

    @Override
    public <T> int calculateShallow(final Class<T> clazz) {
        final Map<String, HistogramEntry> entries = HotSpotHistogram.heapHistogram();
        final HistogramEntry entry = entries.get(clazz.getName());

        if(entry == null) {
            // FIXME object doesn't exist in heap
            return 0;
        }

        return entry.bytes/entry.count;
    }
}