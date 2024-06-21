package com.example.calender_app;



import java.time.LocalDateTime;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class CalendarEventController {

    @Autowired
    private CalendarEventRepository eventRepo;

    @GetMapping("/events/view")
    public String getAllEvents(Model model) {
        System.out.println("Getting all events");
        List<CalendarEvent> events = eventRepo.findAll();
        model.addAttribute("events", events);
        return "showAllEvents";
    }

    @GetMapping("/events/view/{id}")
    public String getEvent(Model model, @PathVariable Long id) {
        System.out.println("GET Event " + id);
        CalendarEvent event = eventRepo.findById(id).orElse(null);
        model.addAttribute("event", event);
        return "showEvent";
    }

    @PostMapping("/events/add")
    public String addEvent(@RequestParam Map<String, String> newEvent, HttpServletResponse response) {
        System.out.println("ADD event");
        String dateTimeString = newEvent.get("dateTime");
        String description = newEvent.get("description");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);

        CalendarEvent event = new CalendarEvent(dateTime, description);

        eventRepo.save(event);
        response.setStatus(201);
        return "addedEvent";
    }
}