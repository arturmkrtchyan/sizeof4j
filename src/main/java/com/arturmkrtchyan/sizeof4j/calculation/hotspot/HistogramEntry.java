package com.arturmkrtchyan.sizeof4j.calculation.hotspot;

class HistogramEntry {

    final int count;
    final int bytes;
    final String className;

    HistogramEntry(final String className, final int count, final int bytes) {
        this.className = className;
        this.count = count;
        this.bytes = bytes;
    }

    HistogramEntry(final String className, final String count, final String bytes) {
        this(className, Integer.valueOf(count), Integer.valueOf(bytes));
    }
}