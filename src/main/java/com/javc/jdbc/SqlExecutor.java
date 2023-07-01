package com.javc.jdbc;

import com.javc.jdbc.dto.User;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SqlExecutor {

    private final Statement statement;

    public SqlExecutor(Statement statement) {
        this.statement = statement;
    }

    @SneakyThrows
    public void executeSqlQuery(String queryLine) {
        statement.executeQuery(queryLine);
    }

    @SneakyThrows
    public void createTable() {
        statement.execute("CREATE TABLE Customer1 (" +
                "id int, " +
                "name varchar(255), " +
                "last_name varchar(255), " +
                "age int" +
                ")");
    }

    public void insertDataIntoTable(List<User> users) {
        users.forEach(user -> {
            try {
                statement.execute("INSERT INTO Customer1 (id, name, last_name, age) " +
                        "VALUES (" +
                        user.id + ", " +
                        "'" + user.name + "', " +
                        "'" + user.lastName + "', " +
                        user.age +
                        ");");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @SneakyThrows
    public ResultSet getResultSet() {
        return statement.executeQuery("SELECT * FROM Customer1");
    }

    @SneakyThrows
    public void clearTable() {
        statement.execute("TRUNCATE TABLE Customer1");
    }

    @SneakyThrows
    public void dropTable() {
        statement.execute("DROP TABLE Customer1");
    }

    public void insertDataIntoTable2(List<String[]> lines) {
        lines.forEach(line -> {
            try {
                statement.execute("INSERT INTO Customer1 (id, name, last_name, age) " +
                        "VALUES (" +
                        line[0] + ", " +
                        "'" + line[1] + "', " +
                        "'" + line[2] + "', " +
                        line[3] +
                        ");");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}