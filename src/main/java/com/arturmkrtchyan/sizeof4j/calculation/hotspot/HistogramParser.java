package com.arturmkrtchyan.sizeof4j.calculation.hotspot;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HistogramParser {

    private static final Pattern PATTERN = Pattern.compile(
            "\\s+(\\d+):{1}\\s+(\\d+)\\s+(\\d+)\\s+(.+)"
    );

    public Map<String, HistogramEntry> parse(final String histogram) {
        final Matcher matcher = PATTERN.matcher("");
        final String[] lines = histogram.split("\\n");
        final Map<String, HistogramEntry> entries = new HashMap<String, HistogramEntry>(lines.length);

        for (final String line : lines) {
            matcher.reset(line);
            if (matcher.matches()) {
                entries.put(
                        matcher.group(4),
                        new HistogramEntry(matcher.group(4),
                                matcher.group(2), matcher.group(3))
                );
            }
        }

        return entries;
    }
}
