package edu.uow.ap.roombooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uow.ap.roombooking.entity.EventLogAP;

public interface EventLogRepository extends JpaRepository<EventLogAP, Long> {

}
