package edu.uow.ap.roombooking.utility;

import java.time.LocalDateTime;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uow.ap.roombooking.entity.Action;
import edu.uow.ap.roombooking.entity.ActionType;
import edu.uow.ap.roombooking.entity.EventLogAP;
import edu.uow.ap.roombooking.entity.Status;
import edu.uow.ap.roombooking.repository.EventLogRepository;

@Service
public class EventLogService {

    private static final Logger logger = LogManager.getLogger(EventLogService.class);

    @Autowired
    private EventLogRepository eventLogRepository;

    public void saveEventLog(Long userId, String username, ActionType actionType, Action action, Status status) {
        logger.info("Attempting to save event log: UserId={}, Username={}, ActionType={}, Action={}, Status={}", userId, username, actionType, action, status);
        
        try {
            // Ensure none of the enum values are null
            if (actionType == null || action == null || status == null) {
                throw new IllegalArgumentException("ActionType, Action, and Status must not be null");
            }

            EventLogAP log = new EventLogAP();
            log.setUserId(userId);
            log.setUsername(username);
            log.setActionType(actionType);
            log.setAction(action);
            log.setStatus(status);
            log.setEventDate(LocalDateTime.now());

            eventLogRepository.save(log);
            logger.info("Event log successfully saved for UserId={}, Action={}", userId, action);

        } catch (IllegalArgumentException e) {
            logger.error("Invalid input provided for EventLog: {}", e.getMessage(), e);
            throw e; // Re-throw to prevent saving incomplete logs
        } catch (Exception e) {
            logger.error("Failed to save event log for UserId={}, Action={}, Error={}", userId, action, e.getMessage(), e);
        }
    }
}
