package com.example.calender_app;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime dateTime;
    private String description;

    // Default constructor
    public CalendarEvent() {}

    // Constructor with parameters
    public CalendarEvent(LocalDateTime dateTime, String description) {
        this.dateTime = dateTime;
        this.description = description;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}