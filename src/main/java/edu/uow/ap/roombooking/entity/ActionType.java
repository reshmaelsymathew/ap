package edu.uow.ap.roombooking.entity;

public enum ActionType {
    CREATE("CREATE"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    GET_BY_ID("GET_BY_ID"),
    GET_ALL("GET_ALL");

    private final String actionTypeName;

    private ActionType(String actionTypeName) {
        this.actionTypeName = actionTypeName;
    }

    public String getActionTypeName() {
        return actionTypeName;
    }

    @Override
    public String toString() {
        return actionTypeName;
    }
}
