package com.javc.jdbc;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class Connector {

    public static Statement statement = null;
    private static Connection connection = null;

    @SneakyThrows
    public Connector getConnection() {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://ec2-52-208-185-143.eu-west-1.compute.amazonaws.com/dbbte6nc0n2o6f";
        Properties props = new Properties();
        props.setProperty("user", "diralmgxzqsotw");
        props.setProperty("password", "ca22a15acd926a843f3539a4d859ab99d1a9158c17688e2b8f71f931fc82d9bd");
        connection = DriverManager.getConnection(url, props);
        statement = connection.createStatement();
        return this;
    }

    @SneakyThrows
    public Connector getStatement() {
        statement = connection.createStatement();
        return this;
    }

    @SneakyThrows
    public Connector closeStatement() {
        statement.close();
        return this;
    }

    @SneakyThrows
    public Connector closeConnection() {
        connection.close();
        return this;
    }
}