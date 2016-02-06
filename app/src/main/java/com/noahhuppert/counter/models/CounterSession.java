package com.noahhuppert.counter.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CounterSession {
    public int id;
    public String name;
    public Calendar creationDate;
    public List<CounterSegment> counterSegments;

    public CounterSession(int id, String name) {
        this.id = id;
        this.name = name;

        creationDate = Calendar.getInstance();

        counterSegments = new ArrayList<>();
        newSegment();
    }

    /* Actions */
    public void increment() {
        getCurrentSegment().increment();
    }

    public void newSegment() {
        counterSegments.add(new CounterSegment());
    }

    /* Getters */
    public int getCount() {
        int count = 0;

        for(CounterSegment segment : counterSegments) {
            count += segment.getCount();
        }

        return count;
    }

    public float getAvrgSegmentCount() {
        return getCount() / getSegmentCount();
    }

    public int getSegmentCount() {
        return counterSegments.size();
    }

    public long getAvrgCountDelay() {
        long delaySum = 0;
        int count = 0;

        for(CounterSegment segment : counterSegments) {
            for(int i = 0; i < segment.getCount(); i++) {
                count += 1;
                delaySum += segment.getCountDelay(i);
            }
        }

        return delaySum / count;
    }

    public CounterSegment getCurrentSegment() {
        return counterSegments.get(counterSegments.size() - 1);
    }
}
