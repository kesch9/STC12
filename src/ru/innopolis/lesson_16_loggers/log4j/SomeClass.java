package ru.innopolis.lesson_16_loggers.log4j;

import org.apache.log4j.Logger;

public class SomeClass {

    final static Logger LOGGER = Logger.getLogger(SomeClass.class);
    public  SomeClass(){
        LOGGER.warn("Warning from SomeClass");
        LOGGER.info("INFO from Some Class");
    }

}
