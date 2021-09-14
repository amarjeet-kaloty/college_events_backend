package com.college_events.college_events.controller;

import com.college_events.college_events.entities.Event;
import com.college_events.college_events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create-event")
    public Event createEvent(@RequestBody Event event ){
        Event event_obj = null;
        event_obj = eventService.createEvent(event);
        System.out.println(event_obj);
        return event_obj;
    }
}
