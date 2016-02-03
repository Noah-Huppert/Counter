package com.noahhuppert.counter.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Counter {
    public String DEFAULT_SESSION_NAME_PREFIX = "Session";
    public String name;
    public Calendar creationDate;
    public List<CounterSession> counterSessions;

    public Counter(String name) {
        this.name = name;

        creationDate = Calendar.getInstance();

        counterSessions = new ArrayList<>();
        newSession();
    }

    /* Actions */
    public void increment() {
        getCurrentSession().increment();
    }

    public void newSession() {
        counterSessions.add(
                new CounterSession(
                        DEFAULT_SESSION_NAME_PREFIX + Integer.toString(getSessionsCount() + 1)
                ));
    }

    /* Getters */
    public int getCount() {
        return getCurrentSession().getCount();
    }

    public int getSessionsCount() {
        return counterSessions.size();
    }

    public float getAvrgSessionCount() {
        int sum = 0;

        for(CounterSession session : counterSessions) {
            sum += session.getCount();
        }

        return sum / getSessionsCount();
    }

    public long getAvrgCountDelay() {
        int totalCount = 0;

        for(CounterSession session : counterSessions) {
            totalCount += session.getCount();
        }

        long avrg = 0;

        for(CounterSession session : counterSessions) {
            avrg += (session.getCount() / totalCount) * (session.getAvrgCountDelay());
        }

        return avrg;
    }

    public CounterSession getCurrentSession() {
        return counterSessions.get(counterSessions.size() - 1);
    }
}
