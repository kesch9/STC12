package ru.innopolis.lesson_16_loggers.log4j;

import org.apache.log4j.Logger;

public class Main {

    final static Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) {

        LOGGER.debug("debug~message");
        LOGGER.info("info-mesage");
        LOGGER.warn("warner");
        LOGGER.error("error");
        LOGGER.fatal("fatal");
        for (int i = 0; i < 10; i++){
            LOGGER.info(i);
        }
        try {
                throw new Exception("test exception");
        } catch (Exception e){
            LOGGER.error(e.getMessage());
        }

        SomeClass someClass = new SomeClass();

    }

}
