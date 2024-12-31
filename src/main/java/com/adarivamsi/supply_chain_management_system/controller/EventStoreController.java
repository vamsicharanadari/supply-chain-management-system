package com.adarivamsi.supply_chain_management_system.controller;

import com.adarivamsi.supply_chain_management_system.model.EventStore;
import com.adarivamsi.supply_chain_management_system.service.EventStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventStoreController {

    @Autowired
    private EventStoreService eventStoreService;

    @GetMapping
    public List<EventStore> getAllEvents() {
        return eventStoreService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Optional<EventStore> getEventById(@PathVariable Long id) {
        return eventStoreService.getEventById(id);
    }

    @GetMapping("/aggregate/{aggregateType}")
    public List<EventStore> getEventByAggregateType(@PathVariable String aggregateType) {
        return eventStoreService.getEventsByAggregateType(aggregateType);
    }

    @PostMapping
    public EventStore createEvent(@RequestBody EventStore eventStore) {
        return eventStoreService.createEvent(eventStore);
    }

    @PutMapping("/{id}")
    public EventStore updateEvent(@PathVariable Long id, @RequestBody EventStore eventStore) {
        return eventStoreService.updateEvent(id, eventStore);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventStoreService.deleteEvent(id);
    }

}