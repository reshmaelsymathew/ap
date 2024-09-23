package edu.uow.ap.roombooking.controller;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    private RoomBookingService roomBookingService;

    // Create a new Room Booking
    @PostMapping
    public ResponseEntity<RoomBooking> createRoomBooking(@RequestBody RoomBooking roomBooking) {
        RoomBooking newBooking = roomBookingService.createRoomBooking(roomBooking);
        return ResponseEntity.ok(newBooking);
    }

    // Get all Room Bookings
    @GetMapping
    public List<RoomBooking> getAllRoomBookings() {
        return roomBookingService.getAllRoomBookings();
    }

    // Get Room Booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<RoomBooking> getRoomBookingById(@PathVariable Long id) {
        Optional<RoomBooking> roomBooking = roomBookingService.getRoomBookingById(id);
        return roomBooking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a Room Booking by ID
    @PutMapping("/{id}")
    public ResponseEntity<RoomBooking> updateRoomBooking(@PathVariable Long id, @RequestBody RoomBooking roomBooking) {
        RoomBooking updatedBooking = roomBookingService.updateRoomBooking(id, roomBooking);
        if (updatedBooking != null) {
            return ResponseEntity.ok(updatedBooking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Room Booking by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomBooking(@PathVariable Long id) {
        roomBookingService.deleteRoomBooking(id);
        return ResponseEntity.noContent().build();
    }
}