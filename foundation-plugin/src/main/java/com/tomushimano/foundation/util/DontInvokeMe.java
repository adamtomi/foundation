package com.tomushimano.foundation.util;

public class DontInvokeMe extends RuntimeException {

    public DontInvokeMe() {
        super("This constructor is private for a reason, please don't invoke it.");
    }
}
