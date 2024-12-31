package com.adarivamsi.supply_chain_management_system.repository;

import com.adarivamsi.supply_chain_management_system.model.EventStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventStoreRepository extends JpaRepository<EventStore, Long> {
    List<EventStore> findByAggregateTypeIgnoreCase(String aggregateType);
}
