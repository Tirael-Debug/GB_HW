import db.DbHandler;
import db.Forecast;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner scanner = new Scanner(System.in);
        String cityName = scanner.nextLine();
        City city = RequestHandler.cityDetect(cityName);
        Forecast forecast = RequestHandler.weatherDetect(city);
        System.out.println(forecast.toString());
        DbHandler dataBase = new DbHandler();
        dataBase.addForecast(forecast);

        System.out.println("\nВывод из базы:");

        List<Forecast> forecastList = dataBase.getAllForecasts();

        for (Forecast dataRow : forecastList) {
            System.out.println(dataRow.toString());
        }
    }
}
