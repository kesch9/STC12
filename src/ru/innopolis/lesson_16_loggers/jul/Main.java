package ru.innopolis.lesson_16_loggers.jul;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.info("message");
        LOGGER.log(Level.INFO,"Testing logger");
        LOGGER.logp(Level.INFO,"Main","main","message text");
        LOGGER.logp(Level.FINEST,"Main","main","message text");
        try {
            FileHandler fileHandler = new FileHandler("JulLog.log");
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,"IO error");
        }

        LOGGER.logp(Level.INFO,"Main","main","message text");
        LOGGER.setLevel(Level.FINEST);
        LOGGER.logp(Level.FINEST,"Main","main","message text");
    }

}
