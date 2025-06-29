package com.fitness.tracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;
    private int duration;
    private int feelScore;
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Workout() {
    }

    public Workout(long id, String type, int duration, int feelScore, LocalDate date, User user) {
        this.id = id;
        this.type = type;
        this.duration = duration;
        this.feelScore = feelScore;
        this.date = date;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getFeelScore() {
        return feelScore;
    }

    public void setFeelScore(int feelScore) {
        this.feelScore = feelScore;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }
}
