package com.javc.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javc.jdbc.dto.Day;
import com.javc.jdbc.dto.Weather;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    @SuppressWarnings("all")
    public static String getResponse() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://community-open-weather-map.p.rapidapi.com/climate/month?q=San%20Francisco")
                .get()
                .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "b5f5c31268mshffcb4a36f6c7777p1eb856jsn247f7613cfee")
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    @SneakyThrows
    public static <T> T getObject(String body, Class<T> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(body, cls);
    }

    public static boolean isDatesEquals(LocalDateTime d1, LocalDateTime d2) {
        return d1.equals(d2);
    }

    public static void main(String[] args) throws IOException {
        List<Day> days = getObject(getResponse(), Weather.class).getDays();

        List<LocalDateTime> dates = new ArrayList<>();

        days.forEach(day -> dates.add(new Timestamp(day.getDt() * 1000).toLocalDateTime()));

        System.out.println(isDatesEquals(dates.get(dates.size() - 1), dates.get(0).plusDays(29)));
    }
}