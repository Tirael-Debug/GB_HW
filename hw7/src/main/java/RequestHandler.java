import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class RequestHandler {

    static OkHttpClient client = new OkHttpClient();
    static ObjectMapper mapper = new ObjectMapper();

    public static String cityDetect(String cityName) throws IOException {
        HttpUrl cityUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(BaseParams.HOST)
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", BaseParams.API_KEY)
                .addQueryParameter("q", cityName)
                .addQueryParameter("language", "en")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(cityUrl)
                .build();

        Response response = client.newCall(request).execute();

        String json = response.body().string();

        if (!response.isSuccessful()) {
            throw new IOException("Запрос не выполнен успешно"
            + " с кодом " + response.code()
            + " с телом " + response.body().string());
        } else if (mapper.readTree(json).size() > 0) {
            String city = mapper.readTree(json).get(0).at("/LocalizedName").asText();
            String country = mapper.readTree(json).get(0).at("/Country/LocalizedName").asText();
            System.out.println(country + " " + city);
        } else {
            throw new IOException("Сервер не вернул города");
        }

        return mapper.readTree(json).get(0).at("/Key").asText();
    }

    public static String weatherDetect(String cityCode) throws IOException {
        HttpUrl weatherUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(BaseParams.HOST)
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityCode)
                .addQueryParameter("apikey", BaseParams.API_KEY)
                .addQueryParameter("language", "en")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(weatherUrl)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Запрос не выполнен успешно"
                    + " с кодом " + response.code()
                    + " с телом " + response.body().string());
        }

        return response.body().string();
    }
}
