package com.javc.jdbc;

import com.javc.csv.open_csv.base_usage.OpenCSV;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class WriteSqlResultToCsvFile {

    @SneakyThrows
    @SuppressWarnings("all")
    public static void main(String[] args) throws SQLException, URISyntaxException, ClassNotFoundException {
        Connection connection = DBConnector.getConnection();
        Statement statement = DBConnector.getStatement();
        SqlExecutor sqlExecutor = new SqlExecutor(statement);
        sqlExecutor.clearTable();

        Reader reader = new FileReader("src/main/java/com/javc/jdbc/Users.CSV");
        List<String[]> lines = OpenCSV.readAll(reader, OpenCSV.getParser(), 1);
        sqlExecutor.insertDataIntoTable2(lines);

        DBConnector.closeStatement();
        DBConnector.closeConnection();
    }
}