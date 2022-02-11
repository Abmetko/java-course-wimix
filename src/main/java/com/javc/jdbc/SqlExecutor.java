package com.javc.jdbc;

import com.javc.jdbc.dto.Day;
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
    public void createTable() {
        statement.execute("CREATE TABLE Temperature (" +
                "average DOUBLE PRECISION, " +
                "average_max DOUBLE PRECISION, " +
                "average_min DOUBLE PRECISION, " +
                "record_max DOUBLE PRECISION, " +
                "record_min DOUBLE PRECISION)");
    }

    public void insertDataIntoTable(List<Day> days) {
        days.forEach(day -> {
            try {
                statement.execute("INSERT INTO Temperature (average, average_max, average_min, record_max, record_min) " +
                        "VALUES (" +
                        day.temp.average + ", " +
                        day.temp.averageMax + ", " +
                        day.temp.averageMin + ", " +
                        day.temp.recordMax + ", " +
                        day.temp.recordMin +
                        ");");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @SneakyThrows
    public ResultSet getResultSet() {
        return statement.executeQuery("SELECT * FROM Temperature");
    }

    @SneakyThrows
    public void clearTable() {
        statement.execute("TRUNCATE TABLE Temperature");
    }

    @SneakyThrows
    public void dropTable() {
        statement.execute("DROP TABLE Temperature");
    }

    //for homework
    public void insertDataIntoTable2(List<String[]> lines) {
        lines.forEach(line -> {
            try {
                statement.execute("INSERT INTO Temperature (average, average_max, average_min, record_max, record_min) " +
                        "VALUES (" +
                        line[0] + ", " +
                        line[1] + ", " +
                        line[2] + ", " +
                        line[3] + ", " +
                        line[4] +
                        ");");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}