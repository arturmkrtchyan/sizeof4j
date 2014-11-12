package com.arturmkrtchyan.sizeof4j.calculation.hotspot;

import com.arturmkrtchyan.sizeof4j.util.IOUtil;
import com.arturmkrtchyan.sizeof4j.util.JvmUtil;

import com.arturmkrtchyan.sizeof4j.calculation.CalculationStrategy;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import sun.tools.attach.HotSpotVirtualMachine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class HistogramCalculationStrategy implements CalculationStrategy {

    private HistogramParser parser;

    public HistogramCalculationStrategy(HistogramParser parser) {
        this.parser = parser;
    }

    @Override
    public int calculateShallow(Object obj) {
        String processId = JvmUtil.processId();

        VirtualMachine vm = null;
        try {
            vm = VirtualMachine.attach(processId);

            InputStream in = ((HotSpotVirtualMachine)vm).heapHisto();
            String histo = IOUtil.read(in);

            Map<String, HistogramEntry> entries = parser.parse(histo);

            // FIXME continue coding.

        } catch (AttachNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

        return 0;
    }
}