package dev.a100c1p43r.cfnotify.controller;

import pl.droidsonroids.retrofit2.JspoonConverterFactory;
import dev.a100c1p43r.cfnotify.data.WorkoutDay;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorkoutController {
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://cf-krakow.cms.efitness.com.pl/")
            .addConverterFactory(JspoonConverterFactory.create())
            .build();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");

    public WorkoutDay getDay(LocalDateTime date) throws IOException {
        WorkoutService service = retrofit.create(WorkoutService.class);
        Response<WorkoutDay> response =  service.getDay(date.format(formatter)).execute();

        if (response.isSuccessful()) {
            return response.body();
        } else {
            throw new RuntimeException("Something went wrong: " + response.errorBody());
        }
    }
}
