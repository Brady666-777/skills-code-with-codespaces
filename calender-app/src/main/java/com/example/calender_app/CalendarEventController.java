package com.example.calender_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/events")
public class CalendarEventController {

    @Autowired
    private CalendarEventRepository repository;

    @PostMapping("/add")
    public CalendarEvent addEvent(@RequestParam String datetime, @RequestParam String description) {
        CalendarEvent event = new CalendarEvent();
        event.setDatetime(LocalDateTime.parse(datetime));
        event.setDescription(description);
        return repository.save(event);
    }
}
