package edu.uow.ap.roombooking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EventLogAP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String username;
    private LocalDateTime loginTime = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private ActionType actionType; // E.g., create, update, delete
    @Enumerated(EnumType.STRING)
    private Action action;  
    @Enumerated(EnumType.STRING)// E.g., RoomBooking created, deleted, etc.
    private Status status;     // success, error
    private LocalDateTime eventDate;
    
    public EventLogAP() {}
    
    	public EventLogAP(Long id, Long userId, String username, LocalDateTime loginTime, ActionType actionType,
			Action action, Status status, LocalDateTime eventDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.loginTime = loginTime;
		this.actionType = actionType;
		this.action = action;
		this.status = status;
		this.eventDate = eventDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDateTime getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}
	public ActionType getActionType() {
		return actionType;
	}
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDateTime getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}
    
    
      

}
