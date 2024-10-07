package edu.uow.ap.roombooking.service;

import java.util.List;

import edu.uow.ap.roombooking.dto.ActionTypeCountDTO;
import edu.uow.ap.roombooking.dto.ActionTypeEventDateDTO;

public interface EventLogApService {
	public List<ActionTypeCountDTO> getCountByActionType();
	
	public List<ActionTypeEventDateDTO> getCountByActionTypeAndEventDate();
	


}
