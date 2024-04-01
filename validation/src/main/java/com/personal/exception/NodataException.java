package com.personal.exception;

public class NodataException extends RuntimeException{
    public NodataException() {
        super();
    }

    public NodataException(String message) {
        super(message);
    }

    public NodataException(String message, Throwable cause) {
        super(message, cause);
    }

    public NodataException(Throwable cause) {
        super(cause);
    }

    protected NodataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
