package com.adarivamsi.supply_chain_management_system.service;

import com.adarivamsi.supply_chain_management_system.model.EventStore;
import com.adarivamsi.supply_chain_management_system.repository.EventStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventStoreService {

    @Autowired
    private EventStoreRepository eventStoreRepository;

    /**
     * Retrieves all events from the event store.
     *
     * @return List of all events.
     */
    public List<EventStore> getAllEvents() {
        return eventStoreRepository.findAll();
    }

    /**
     * Retrieves a specific event by its ID.
     *
     * @param id the ID of the event.
     * @return the event, if found.
     */
    public Optional<EventStore> getEventById(Long id) {
        return eventStoreRepository.findById(id);
    }

    /**
     * Stores a new event in the event store.
     *
     * @param eventStore the event to store.
     * @return the stored event.
     */
    public EventStore createEvent(EventStore eventStore) {
        eventStore.setCreatedAt(new Date());
        return eventStoreRepository.save(eventStore);
    }

    /**
     * Deletes an event from the event store by its ID.
     *
     * @param id the ID of the event to delete.
     */
    public void deleteEvent(Long id) {
        if (eventStoreRepository.existsById(id)) {
            eventStoreRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Event not found with ID: " + id);
        }
    }

    public EventStore updateEvent(Long id, EventStore updatedEvent) {
        return eventStoreRepository.findById(id).map(existingEvent -> {
            existingEvent.setAggregateType(updatedEvent.getAggregateType());
            existingEvent.setAggregateId(updatedEvent.getAggregateId());
            existingEvent.setEventType(updatedEvent.getEventType());
            existingEvent.setEventData(updatedEvent.getEventData());
            existingEvent.setCreatedAt(existingEvent.getCreatedAt());
            return eventStoreRepository.save(existingEvent);
        }).orElseThrow(() -> new IllegalArgumentException("Event not found with ID: " + id));
    }

    /**
     * Retrieves all events of a specific aggregate type.
     *
     * @param aggregateType the type of aggregate.
     * @return List of events for the specified aggregate type.
     */
    public List<EventStore> getEventsByAggregateType(String aggregateType) {
        return eventStoreRepository.findByAggregateTypeIgnoreCase(aggregateType);
    }

}
