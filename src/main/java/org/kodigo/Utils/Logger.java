package org.kodigo.Utils;

import org.apache.logging.log4j.LogManager;

public class Logger {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Logger.class);

    public static void main(String[] args) {
        LOGGER.info("This is a New INFO level on The main Project!");
        LOGGER.error("This is an ERROR level on the main Project");
    }

    public static void logInfo(String s){
        LOGGER.info(s);

    }

    public static void logError(String s){
        LOGGER.error(s);
    }

}
