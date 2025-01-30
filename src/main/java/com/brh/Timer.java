package com.brh;

import java.time.LocalDateTime;

/**
 * Modelklasse zu reinen Speicherung von Daten
 * keine Funktionalität
 */
public class Timer {

    private int time;
    private LocalDateTime timeStamp;

    private String description;

    public Timer(int time, LocalDateTime timeStamp, String description) {
        this.time = time;
        this.timeStamp = timeStamp;
        this.description = description;
    }

    public Timer(int time, String description) {
        this.time = time;
        this.description = description;
        this.timeStamp = LocalDateTime.now();
    }

    public int getTime() {
        return time;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getDescription() {
        return description;
    }
}
