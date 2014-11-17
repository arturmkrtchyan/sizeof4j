package com.arturmkrtchyan.sizeof4j;

public class SizeOfException extends RuntimeException {

    private static final long serialVersionUID = 602133648144972294L;

    public SizeOfException(String message) {
        super(message);
    }

    public SizeOfException(String message, Throwable cause) {
        super(message, cause);
    }

    public SizeOfException(Throwable cause) {
        super(cause);
    }
}
