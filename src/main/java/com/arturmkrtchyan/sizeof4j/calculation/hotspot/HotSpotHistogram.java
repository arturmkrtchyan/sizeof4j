package com.arturmkrtchyan.sizeof4j.calculation.hotspot;

import com.arturmkrtchyan.sizeof4j.util.IOUtil;
import com.arturmkrtchyan.sizeof4j.util.JvmUtil;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import sun.tools.attach.HotSpotVirtualMachine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotSpotHistogram {

    private static final Pattern PATTERN = Pattern.compile(
            "\\s+(\\d+):{1}\\s+(\\d+)\\s+(\\d+)\\s+(.+)"
    );

    public static Map<String, HistogramEntry> heapHistogram() {
        String processId = JvmUtil.processId();

        VirtualMachine vm = null;
        try {
            vm = VirtualMachine.attach(processId);

            InputStream in = ((HotSpotVirtualMachine)vm).heapHisto();
            String histo = IOUtil.read(in);

            return parse(histo);

        } catch (AttachNotSupportedException | IOException e) {
            e.printStackTrace();
        } finally {
            if(vm != null) {
                try {
                    vm.detach();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Collections.emptyMap();
    }

    protected static Map<String, HistogramEntry> parse(final String histogram) {
        final Matcher matcher = PATTERN.matcher("");
        final String[] lines = histogram.split("\\n");
        final Map<String, HistogramEntry> entries = new HashMap<>(lines.length);

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
