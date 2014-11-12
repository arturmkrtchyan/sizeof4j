package com.arturmkrtchyan.sizeof4j.util;


import java.io.IOException;
import java.io.InputStream;

public class IOUtil {

    private IOUtil() {}

    public static String read(InputStream in) throws IOException {
        StringBuilder builder = new StringBuilder();
        byte b[] = new byte[256];
        int n;
        do {
            n = in.read(b);
            if (n > 0) {
                builder.append(new String(b, 0, n, "UTF-8"));
            }
        } while (n > 0);
        in.close();
        return builder.toString();
    }

}
