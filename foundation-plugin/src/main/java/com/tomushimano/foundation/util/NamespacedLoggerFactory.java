package com.tomushimano.foundation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NamespacedLoggerFactory {
    private static final String FORMAT = "foundation:%s";

    private NamespacedLoggerFactory() {
        throw new DontInvokeMe();
    }

    public static Logger create(String name) {
        return LoggerFactory.getLogger(FORMAT.formatted(name));
    }
}
