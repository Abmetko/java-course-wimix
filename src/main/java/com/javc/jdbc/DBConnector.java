package com.javc.jdbc;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import static com.javc.properties.PropertyProvider.getProperty;

public class DBConnector {

    private static Statement statement = null;
    private static Connection connection = null;

    /**
     * Before you can connect to a database, you need to load the driver. There are two methods available, and it depends on your code which is the best one to use.
     * <p>
     * In the first method, your code implicitly loads the driver using the Class.forName() method. For PostgreSQL™, you would use:
     * <p>
     * Class.forName("org.postgresql.Driver");
     * This will load the driver, and while loading, the driver will automatically register itself with JDBC.
     * <p>
     * This is the most common method to use, but restricts your code to use just PostgreSQL™. If your code may access another database system in the future, and you do not use any PostgreSQL™-specific extensions, then the second method is advisable.
     * <p>
     * The second method passes the driver as a parameter to the JVM as it starts, using the -D argument. Example:
     * <p>
     * java -Djdbc.drivers=org.postgresql.Driver example.ImageViewer
     * In this example, the JVM will attempt to load the driver as part of its initialization. Once done, the ImageViewer is started.
     */
    @SneakyThrows
    public void getConnection() {
        Class.forName("org.postgresql.Driver");
        String url = getProperty("jdbc.url");
        Properties props = new Properties();
        props.setProperty("user", getProperty("jdbc.user"));
        props.setProperty("password", getProperty("jdbc.password"));
        connection = DriverManager.getConnection(url, props);
    }

    @SneakyThrows
    public Statement getStatement() {
        if (statement == null) {
            statement = connection.createStatement();
        }
        return statement;
    }

    @SneakyThrows
    public void closeStatement() {
        statement.close();
    }

    @SneakyThrows
    public void closeConnection() {
        connection.close();
    }
}