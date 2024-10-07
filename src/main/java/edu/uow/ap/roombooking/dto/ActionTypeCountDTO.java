package edu.uow.ap.roombooking.dto;


public class ActionTypeCountDTO {
    private String actionType;  // Change this to ActionType enum
    private Long count;

    // Constructor
    public ActionTypeCountDTO(String actionType, Long count) {
        this.actionType = actionType;
        this.count = count;
    }

    // Getters and Setters
    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
