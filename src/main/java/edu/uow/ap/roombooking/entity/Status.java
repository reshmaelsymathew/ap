package edu.uow.ap.roombooking.entity;

public enum Status {
    SUCCESS("SUCCESS"),
    ERROR("ERROR");

    private final String statusName;

    private Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    @Override
    public String toString() {
        return statusName;
    }
}
