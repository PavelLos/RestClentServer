package com.pavel.server.data.base;


import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * класс для работы с бд
 */
public class DBWorker {
    private static DBWorker instance = null;
    private static final String URL = "jdbc:mysql://localhost:3306/student_base";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Logger log = Logger.getLogger(DBWorker.class);

    private Connection connection = null;

    /**
     * создание объекта
     */
    private DBWorker() {
    }

    /**
     * метод для открытия подключения
     */
    public void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("open connection with " + URL);
        } catch (SQLException e) {
            log.error("Could not open connection with DB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод для закрытия подключения
     */
    public void closeConnection() {
        try {
            connection.close();
            log.info("close connection");
        } catch (SQLException e) {
            log.error("Could not close connection with DB");
        }
    }

    public static DBWorker getInstance() {
        if (instance == null) {
            instance = new DBWorker();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public static String getURL() {
        return URL;
    }
}
