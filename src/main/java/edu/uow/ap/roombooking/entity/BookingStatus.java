package edu.uow.ap.roombooking.entity;

public enum BookingStatus {
	CONFIRMED("Confirmed"),
	PENDING("Pending"), 
	CANCELLED("Cancelled");
	
	private final String displayName;
	
	BookingStatus(String displayName) {
	        this.displayName = displayName;
	    }

	    public String getDisplayName() {
	        return displayName;
	    }

	    @Override
	    public String toString() {
	        return "BookingStatus{" +
	                "displayName='" + displayName + '\'' +
	                '}';
	    }

}
