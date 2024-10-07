package edu.uow.ap.roombooking.dto;



public class ActionTypeEventDateDTO {
    private String actionType;
    private String eventDate; // Change from Date to String
    private Long count;

    // Constructor
    public ActionTypeEventDateDTO(String actionType, String eventDate, Long count) {
        this.actionType = actionType;
        this.eventDate = eventDate; // Use String
        this.count = count;
    }

    // Getters and Setters
    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getEventDate() {
        return eventDate; // Use String
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate; // Use String
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
