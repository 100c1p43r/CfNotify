package pl.dusik.cfnotify.controller;

import pl.dusik.cfnotify.data.WorkoutDay;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WorkoutService {
    @GET("/kalendarz-zajec?view=DayByHour")
    Call<WorkoutDay> getDay(@Query("day") String date);
}
