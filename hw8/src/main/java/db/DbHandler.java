package db;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {

    private final String DB_PATH = "jdbc:sqlite:hw8\\src\\main\\resources\\forecast.db";

    private Connection connection;

    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(DB_PATH);
    }

    public void addForecast(Forecast forecast) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO forecast('city','date','info','minTemp','maxTemp') " +
                        "VALUES(?,?,?,?,?)"

        )) {
            statement.setObject(1, forecast.getCity());
            statement.setObject(2, new Timestamp(forecast.getDate().getTime()));
            statement.setObject(3, forecast.getInfo());
            statement.setObject(4, forecast.getMinTemp());
            statement.setObject(5, forecast.getMaxTemp());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<Forecast> getAllForecasts() {
        List<Forecast> forecastList = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM forecast");
            while (resultSet.next()) {
                forecastList.add(new Forecast(
                        resultSet.getInt("id"),
                        resultSet.getString("city"),
                        new Date(resultSet.getLong("date")),
                        resultSet.getString("info"),
                        resultSet.getDouble("minTemp"),
                        resultSet.getDouble("maxTemp")
                ));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return forecastList;
    }
}
