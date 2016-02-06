package com.noahhuppert.counter.models;

import java.util.ArrayList;
import java.util.List;

public class CounterSegment {
    public int id;
    public List<Long> countTimes;

    public CounterSegment(int id) {
        this.id = id;
        countTimes = new ArrayList<>();
    }

    /* Actions */
    public void increment() {
        countTimes.add(System.currentTimeMillis());
    }

    /* Getters */
    public int getCount() {
        return countTimes.size();
    }

    public long getCountDelay(int countIndex) {
        long lastCountTime = 0;

        if(countIndex == 0) {
            lastCountTime = countTimes.get(0);
        } else {
            lastCountTime = countTimes.get(countIndex - 1);
        }

        return countTimes.get(countIndex) - lastCountTime;
    }

    public long getAvrgCountDelay() {
        long sum = 0;

        for(int i = 0; i < countTimes.size(); i++) {
            sum += getCountDelay(i);
        }

        return sum / countTimes.size();
    }
}
