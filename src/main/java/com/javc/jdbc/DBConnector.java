package com.javc.jdbc;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DBConnector {

    private static Statement statement = null;
    private static Connection connection = null;

    @SneakyThrows
    public void getConnection() {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://ec2-52-208-185-143.eu-west-1.compute.amazonaws.com/dbbte6nc0n2o6f";
        Properties props = new Properties();
        props.setProperty("user", "diralmgxzqsotw");
        props.setProperty("password", "ca22a15acd926a843f3539a4d859ab99d1a9158c17688e2b8f71f931fc82d9bd");
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