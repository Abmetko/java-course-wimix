package com.javc.jdbc;

import com.javc.csv.open_csv.base_usage.OpenCSV;
import com.javc.jdbc.dto.Day;
import com.javc.jdbc.dto.Weather;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.javc.jdbc.Generator.getResponse;

public class WriteSqlResultToCsvFile {

    @SneakyThrows
    @SuppressWarnings("all")
    public static void main(String[] args) throws SQLException, URISyntaxException, ClassNotFoundException {
        DBConnector connector = new DBConnector();

        connector.getConnection();

        Statement statement = connector.getStatement();

        SqlExecutor sqlExecutor = new SqlExecutor(statement);

        sqlExecutor.clearTable();

        List<Day> days = Generator.parse(getResponse(), Weather.class).getDays();

        sqlExecutor.insertDataIntoTable(days);

        ResultSet resultSet = sqlExecutor.getResultSet();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("average").append(",")
                .append("average_max").append(",")
                .append("average_min").append(",")
                .append("record_max").append(",")
                .append("record_min")
                .append("\n");

        while (resultSet.next()) {
            stringBuilder.append(resultSet.getString("average")).append(",");
            stringBuilder.append(resultSet.getString("average_max")).append(",");
            stringBuilder.append(resultSet.getString("average_min")).append(",");
            stringBuilder.append(resultSet.getString("record_max")).append(",");
            stringBuilder.append(resultSet.getString("record_min"));
            stringBuilder.append("\n");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);//delete the last symbol --> "\n"

        FileWriter fileWriter = new FileWriter("src/main/java/com/javc/jdbc/temperatures.CSV");
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();

        //homework --> read data from csv file and inject them into table(data base)
        sqlExecutor.clearTable();

        Reader reader = new FileReader("src/main/java/com/javc/jdbc/temperatures.CSV");

        List<String[]> lines = OpenCSV.readAll(reader, OpenCSV.getParser(), 1);

        sqlExecutor.insertDataIntoTable2(lines);

        connector.closeStatement();
        connector.closeConnection();
    }
}