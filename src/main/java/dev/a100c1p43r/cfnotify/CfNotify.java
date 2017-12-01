package dev.a100c1p43r.cfnotify;

import dev.a100c1p43r.cfnotify.controller.WorkoutController;
import dev.a100c1p43r.cfnotify.data.Workout;
import dev.a100c1p43r.cfnotify.data.WorkoutDay;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class CfNotify {
    private static final WorkoutController controller = new WorkoutController();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String... args) {
        LocalDateTime date = parseArgs(args);

        try {
            WorkoutDay day = controller.getDay(date);

            Workout workout =
                    day.getWorkoutByHour(date.format(formatter)).orElseThrow(
                            () -> new RuntimeException("No such workout"));
            System.out.println(workout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static LocalDateTime parseArgs(String... args) {
        if (args.length < 1) {
            throw new RuntimeException("Please execute with date parameter in following scheme 2011-12-03T10:15:30");
        } else {
            return LocalDateTime.from(ISO_LOCAL_DATE_TIME.parse(args[0]));
        }
    }
}
