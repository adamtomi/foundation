package com.tomushimano.foundation.util;

import org.slf4j.Logger;

public final class ExceptionUtil {
    private static final String VERT_SEPARATOR = "+------------------------------------------------------------------------+";
    private static final String ERROR = "AN UNEXPECTED ERROR HAS OCCURRED";

    private ExceptionUtil() {
        throw new DontInvokeMe();
    }

    public static void dumpStackTrace(Logger logger, String detail, Throwable ex) {
        logger.error(VERT_SEPARATOR);
        logger.error(ERROR);
        logger.error("");
        logger.error(">> {}", detail);
        logger.error("", ex);
        logger.error("");
        logger.error(VERT_SEPARATOR);
    }
}
