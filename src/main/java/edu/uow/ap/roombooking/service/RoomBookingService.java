package edu.uow.ap.roombooking.service;

import java.util.List;
import java.util.Optional;

import edu.uow.ap.roombooking.entity.RoomBooking;

public interface RoomBookingService {
    RoomBooking createRoomBooking(RoomBooking roomBooking);
    List<RoomBooking> getAllRoomBookings();
    Optional<RoomBooking> getRoomBookingById(Long id);
    RoomBooking updateRoomBooking(Long id, RoomBooking roomBooking);
    void deleteRoomBooking(Long id);
}