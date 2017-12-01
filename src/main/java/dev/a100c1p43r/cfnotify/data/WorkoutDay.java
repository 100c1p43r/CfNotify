package dev.a100c1p43r.cfnotify.data;

import pl.droidsonroids.jspoon.annotation.Selector;

import java.util.List;
import java.util.Optional;

public class WorkoutDay {
    @Selector("table.calendar_table_day tbody tr")
    List<Workout> workouts;

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public Optional<Workout> getWorkoutByHour(String hour) {
        return workouts.parallelStream().filter(w -> w.getHour().equals(hour)).findFirst();
    }

    @Override
    public String toString() {
        return "WorkoutDay{" +
                "workouts=" + workouts +
                '}';
    }
}
