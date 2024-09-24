package edu.uow.ap.roombooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uow.ap.roombooking.entity.EventLog;

public interface EventLogRepository extends JpaRepository<EventLog, Long> {

}
