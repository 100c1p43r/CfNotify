package dev.a100c1p43r.cfnotify.data;

import pl.droidsonroids.jspoon.annotation.Selector;

public class Workout {
    @Selector("td.hour")
    String hour;

    @Selector("p.event_name")
    String name;

    @Selector("span.availability-number")
    Integer available;

    public String getHour() {
        return hour;
    }

    public String getName() {
        return name;
    }

    public Integer getAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "hour=" + hour +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
