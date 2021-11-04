import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import db.Forecast;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class RequestHandler {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    static OkHttpClient client = new OkHttpClient();
    static ObjectMapper mapper = new ObjectMapper();

    public static City cityDetect(String city) throws IOException {
        HttpUrl cityUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(BaseParams.HOST)
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", BaseParams.API_KEY)
                .addQueryParameter("q", city)
                .addQueryParameter("language", "ru")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(cityUrl)
                .build();

        Response response = client.newCall(request).execute();

        String json = response.body().string();
        String cityId;
        String cityName;

        if (!response.isSuccessful()) {
            throw new IOException("Запрос не выполнен успешно"
                    + " с кодом " + response.code()
                    + " с телом " + response.body().string());
        } else if (mapper.readTree(json).size() > 0) {
            cityId = mapper.readTree(json).get(0).at("/Key").asText();
            cityName = mapper.readTree(json).get(0).at("/LocalizedName").asText();
            String country = mapper.readTree(json).get(0).at("/Country/LocalizedName").asText();

            System.out.println(country + " " + cityName);
        } else {
            throw new IOException("Сервер не вернул города");
        }

        return new City(cityId, cityName);
    }

    public static Forecast weatherDetect(City city) throws IOException {
        HttpUrl weatherUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(BaseParams.HOST)
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("1day")
                .addPathSegment(city.getCityId())
                .addQueryParameter("apikey", BaseParams.API_KEY)
                .addQueryParameter("language", "ru")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(weatherUrl)
                .build();

        Response response = client.newCall(request).execute();
        String json = response.body().string();

        if (!response.isSuccessful()) {
            throw new IOException("Запрос не выполнен успешно"
                    + " с кодом " + response.code()
                    + " с телом " + response.body().string());
        } else {
            JsonNode forecastResp = mapper.readTree(json);
            Forecast resultForecast = null;

            try {
                if (Objects.nonNull(forecastResp)) {
                    int id = 0;
                    Date date = dateFormat.parse(forecastResp.at("/Headline/EffectiveDate").asText());
                    String info = forecastResp.at("/Headline/Text").asText();
                    double minTemp = forecastResp.at("/DailyForecasts").get(0).at("/Temperature/Minimum/Value").asInt();
                    double maxTemp = forecastResp.at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asInt();
                    resultForecast = new Forecast(
                            id,
                            city.getCityName(),
                            date,
                            info,
                            minTemp,
                            maxTemp
                    );
                } else {
                    throw new IOException("Не получилось распознать параметры ответа");
                }
            } catch (ParseException parseException) {
                throw new IOException("Не получилось распознать дату в параметрах ответа");
            }

            return resultForecast;
        }
    }
}
