package com.driver;

import java.util.*;
import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar;

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        Collections.sort(calendar);
        int maxMeetings = 0;
        int currentMeetings = 0;
        Iterator<Meeting> iterator = calendar.iterator();
        while (iterator.hasNext()) {
            Meeting meeting = iterator.next();
            if (meeting.getStartTime().isAfter(meeting.getEndTime())) {
                continue;
            }
            while (iterator.hasNext() && !meeting.getStartTime().isAfter(iterator.next().getEndTime())) {
                currentMeetings++;
                iterator.remove();
            }
            if (currentMeetings > maxMeetings) {
                maxMeetings = currentMeetings;
            }
            currentMeetings = 0;
        }
        return maxMeetings;
    }
}