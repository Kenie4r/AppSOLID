package org.kodigo.Utils;

import org.apache.logging.log4j.LogManager;

public class Logger {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Logger.class);

    public static void main(String[] args) {
        LOGGER.info("This is a New INFO  on The main Project!");
        LOGGER.error("This is an ERROR  on the main Project");
    }

    public static void logInfo(String s){
        LOGGER.info(s);

    }

    public static void logError(String s){
        LOGGER.error(s);
    }

}
