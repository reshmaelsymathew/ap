package edu.uow.ap.roombooking.entity;

public enum Action {
    ROOM_BOOKING_CREATE("ROOM_BOOKING_CREATE"),
    ROOM_BOOKING_UPDATE("ROOM_BOOKING_UPDATE"),
    ROOM_BOOKING_DELETE("ROOM_BOOKING_DELETE"),
    ROOM_BOOKING_GET_BY_ID("ROOM_BOOKING_GET_BY_ID"),
    ROOM_BOOKING_GET_ALL("ROOM_BOOKING_GET_ALL");

    private final String actionName;

    private Action(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }

    @Override
    public String toString() {
        return actionName;
    }
}
