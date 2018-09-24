package ru.innopolis.lesson_15_jdbc.realExample.connectionManager;

import java.sql.Connection;

public interface ConnectionManager {
    public Connection getConnection();
}
