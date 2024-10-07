package edu.uow.ap.roombooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.uow.ap.roombooking.entity.EventLogAP;

public interface EventLogRepository extends JpaRepository<EventLogAP, Long> {

	@Query("SELECT COUNT(e) AS count, e.actionType, e.eventDate FROM EventLogAP e GROUP BY e.actionType, e.eventDate")
	List<Object[]> getCountByActionTypeAndEventDate();

	@Query("SELECT COUNT(e) AS count, e.actionType FROM EventLogAP e GROUP BY e.actionType")
	List<Object[]> getCountByActionType();



}
