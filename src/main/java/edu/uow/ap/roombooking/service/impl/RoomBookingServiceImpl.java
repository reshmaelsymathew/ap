package edu.uow.ap.roombooking.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uow.ap.roombooking.entity.Action;
import edu.uow.ap.roombooking.entity.ActionType;
import edu.uow.ap.roombooking.entity.RoomBooking;
import edu.uow.ap.roombooking.entity.Status;
import edu.uow.ap.roombooking.repository.RoomBookingRepository;
import edu.uow.ap.roombooking.service.RoomBookingService;
import edu.uow.ap.roombooking.utility.EventLogService;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

    private static final Logger logger = LogManager.getLogger(RoomBookingServiceImpl.class);

    @Autowired
    private RoomBookingRepository roomBookingRepository;

    @Autowired
    private EventLogService eventLogService;

    @Override
    public RoomBooking createRoomBooking(RoomBooking roomBooking) {
        logger.info("[AP] Creating a new room booking: {}", roomBooking);
        RoomBooking booking = roomBookingRepository.save(roomBooking);
        
        logger.info("[AP] Room booking created with ID: {}", booking.getId());
        // Log event after creating a room booking
        eventLogService.saveEventLog(booking.getId(), booking.getCustomerName(), ActionType.CREATE, Action.ROOM_BOOKING_CREATE, Status.SUCCESS);
        
        return booking;
    }

    @Override
    public List<RoomBooking> getAllRoomBookings() {
        logger.info("[AP] Fetching all room bookings.");
        List<RoomBooking> bookings = roomBookingRepository.findAll();

        logger.info("[AP] Fetched {} room bookings.", bookings.size());
        // Log event after fetching all room bookings
        eventLogService.saveEventLog(1L, "admin", ActionType.GET_ALL, Action.ROOM_BOOKING_GET_ALL, Status.SUCCESS);
        
        return bookings;
    }

    @Override
    public Optional<RoomBooking> getRoomBookingById(Long id) {
        logger.info("[AP] Fetching room booking with ID: {}", id);
        Optional<RoomBooking> booking = roomBookingRepository.findById(id);

        if (booking.isPresent()) {
            logger.info("[AP] Room booking found: {}", booking.get());
            eventLogService.saveEventLog(booking.get().getId(), booking.get().getCustomerName(), ActionType.GET_BY_ID, Action.ROOM_BOOKING_GET_BY_ID, Status.SUCCESS);
        } else {
            logger.warn("[AP]  Room booking with ID {} not found.", id);
            eventLogService.saveEventLog(id, "admin", ActionType.GET_BY_ID, Action.ROOM_BOOKING_GET_BY_ID, Status.ERROR);
        }

        return booking;
    }

    @Override
    public RoomBooking updateRoomBooking(Long id, RoomBooking roomBooking) {
        logger.info("[AP] Updating room booking with ID: {}", id);
        Optional<RoomBooking> existingBooking = roomBookingRepository.findById(id);

        if (existingBooking.isPresent()) {
            RoomBooking updatedBooking = existingBooking.get();
            updatedBooking.setCustomerName(roomBooking.getCustomerName());
            updatedBooking.setRoomType(roomBooking.getRoomType());
            updatedBooking.setNumberOfGuests(roomBooking.getNumberOfGuests());
            updatedBooking.setCheckInDate(roomBooking.getCheckInDate());
            updatedBooking.setCheckOutDate(roomBooking.getCheckOutDate());
            updatedBooking.setTotalPrice(roomBooking.getTotalPrice());
            updatedBooking.setBookingStatus(roomBooking.getBookingStatus());

            logger.info("[AP] Room booking updated successfully: {}", updatedBooking);
            // Log successful update event
            eventLogService.saveEventLog(existingBooking.get().getId(), existingBooking.get().getCustomerName(), ActionType.UPDATE, Action.ROOM_BOOKING_UPDATE, Status.SUCCESS);

            return roomBookingRepository.save(updatedBooking);
        } else {
            logger.warn("[AP]  Room booking with ID {} not found for update.", id);
            // Log failed update event
            eventLogService.saveEventLog(id, "admin", ActionType.UPDATE, Action.ROOM_BOOKING_UPDATE, Status.ERROR);
            return null;
        }
    }

    @Override
    public void deleteRoomBooking(Long id) {
        logger.info("[AP] Deleting room booking with ID: {}", id);
        try {
            roomBookingRepository.deleteById(id);
            logger.info("[AP] Room booking with ID {} deleted successfully.", id);
            
            // Log successful delete event
            eventLogService.saveEventLog(id, "admin", ActionType.DELETE, Action.ROOM_BOOKING_DELETE, Status.SUCCESS);
        } catch (Exception e) {
            logger.error("[AP]  Failed to delete room booking with ID {}. Error: {}", id, e.getMessage());
            // Log failed delete event
            eventLogService.saveEventLog(id, "admin", ActionType.DELETE, Action.ROOM_BOOKING_DELETE, Status.ERROR);
        }
    }
}
