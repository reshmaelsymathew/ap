package edu.uow.ap.roombooking.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uow.ap.roombooking.entity.RoomBooking;
import edu.uow.ap.roombooking.service.RoomBookingService;

@RestController
@RequestMapping("/api/roombookings")
public class RoomBookingController {

    private static final Logger logger = LogManager.getLogger(RoomBookingController.class);

    @Autowired
    private RoomBookingService roomBookingService;

    // Create a new Room Booking
    @PostMapping
    public ResponseEntity<RoomBooking> createRoomBooking(@RequestBody RoomBooking roomBooking) {
        logger.info("[AP] Received request to create room booking: {}", roomBooking);
        RoomBooking newBooking = roomBookingService.createRoomBooking(roomBooking);
        logger.info("[AP] Room booking created with ID: {}", newBooking.getId());
        return ResponseEntity.ok(newBooking);
    }

    // Get all Room Bookings
    @GetMapping
    public List<RoomBooking> getAllRoomBookings() {
        logger.info("[AP] Received request to fetch all room bookings.");
        List<RoomBooking> bookings = roomBookingService.getAllRoomBookings();
        logger.info("[AP] Fetched {} room bookings.", bookings.size());
        return bookings;
    }

    // Get Room Booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<RoomBooking> getRoomBookingById(@PathVariable Long id) {
        logger.info("[AP] Received request to fetch room booking with ID: {}", id);
        Optional<RoomBooking> roomBooking = roomBookingService.getRoomBookingById(id);
        if (roomBooking.isPresent()) {
            logger.info("[AP] Room booking found: {}", roomBooking.get());
            return ResponseEntity.ok(roomBooking.get());
        } else {
            logger.warn("[AP] Room booking with ID {} not found.", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Update a Room Booking by ID
    @PutMapping("/{id}")
    public ResponseEntity<RoomBooking> updateRoomBooking(@PathVariable Long id, @RequestBody RoomBooking roomBooking) {
        logger.info("[AP] Received request to update room booking with ID: {}", id);
        RoomBooking updatedBooking = roomBookingService.updateRoomBooking(id, roomBooking);
        if (updatedBooking != null) {
            logger.info("[AP] Room booking with ID {} updated successfully.", id);
            return ResponseEntity.ok(updatedBooking);
        } else {
            logger.warn("[AP] Room booking with ID {} not found for update.", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Room Booking by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomBooking(@PathVariable Long id) {
        logger.info("[AP] Received request to delete room booking with ID: {}", id);
        roomBookingService.deleteRoomBooking(id);
        logger.info("[AP] Room booking with ID {} deleted.", id);
        return ResponseEntity.noContent().build();
    }
}