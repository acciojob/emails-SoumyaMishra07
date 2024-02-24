package com.driver;

import java.time.LocalTime;

public class Meeting implements Comparable<Meeting> {
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(Meeting o) {
        return this.startTime.compareTo(o.startTime);
    }
}