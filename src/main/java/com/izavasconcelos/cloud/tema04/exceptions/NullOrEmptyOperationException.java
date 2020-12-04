package com.izavasconcelos.cloud.tema04.exceptions;

public class NullOrEmptyOperationException extends RuntimeException {
    public NullOrEmptyOperationException(String e) {
        super(e);
    }
}
