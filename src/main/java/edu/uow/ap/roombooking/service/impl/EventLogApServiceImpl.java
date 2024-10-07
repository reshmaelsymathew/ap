package edu.uow.ap.roombooking.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uow.ap.roombooking.dto.ActionTypeCountDTO;
import edu.uow.ap.roombooking.dto.ActionTypeEventDateDTO;
import edu.uow.ap.roombooking.entity.ActionType;
import edu.uow.ap.roombooking.repository.EventLogRepository;
import edu.uow.ap.roombooking.service.EventLogApService;

@Service
public class EventLogApServiceImpl implements EventLogApService{
	
	@Autowired
	private EventLogRepository eventLogRepository;

	@Override
	public List<ActionTypeCountDTO> getCountByActionType() {
		 List<Object[]> eventLogCountActionTypeList = eventLogRepository.getCountByActionType();
	        List<ActionTypeCountDTO> result = new ArrayList<>();

	        for (Object[] obj : eventLogCountActionTypeList) {
	            Long count = (Long) obj[0];               // Get the count
	            ActionType actionType = (ActionType) obj[1]; // Get the action type as ActionType enum
	            
	            // Convert ActionType enum to String using its name or value
	            String actionTypeString = actionType.name(); // or actionType.toString();
	            
	            result.add(new ActionTypeCountDTO(actionTypeString, count)); // Create a new DTO instance
	        }

	        return result; // Return the list of DTOs
	}

	@Override
	public List<ActionTypeEventDateDTO> getCountByActionTypeAndEventDate() {
	    List<Object[]> eventLogCountActionTypeAndDateList = eventLogRepository.getCountByActionTypeAndEventDate();
	    List<ActionTypeEventDateDTO> result = new ArrayList<>();

	    // Define a DateTimeFormatter to format the date
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    for (Object[] obj : eventLogCountActionTypeAndDateList) {
	        Long count = (Long) obj[0]; // Get the count
	        ActionType actionType = (ActionType) obj[1]; // Get the action type as ActionType enum
	        LocalDateTime eventDateTime = (LocalDateTime) obj[2]; // Get the event date as LocalDateTime

	        // Convert ActionType enum to String
	        String actionTypeString = actionType.name(); // or actionType.toString();

	        // Format the LocalDateTime to String in "yyyy-MM-dd"
	        String formattedDate = eventDateTime.format(dateFormatter); // Format the date

	        // Create a new DTO instance with the formatted date
	        result.add(new ActionTypeEventDateDTO(actionTypeString, formattedDate, count)); 
	    }

	    return result; // Return the list of DTOs
	}


}
