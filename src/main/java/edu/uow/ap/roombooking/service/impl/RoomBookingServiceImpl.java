package edu.uow.ap.roombooking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uow.ap.roombooking.entity.RoomBooking;
import edu.uow.ap.roombooking.repository.RoomBookingRepository;
import edu.uow.ap.roombooking.service.RoomBookingService;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

    @Autowired
    private RoomBookingRepository roomBookingRepository;

    @Override
    public RoomBooking createRoomBooking(RoomBooking roomBooking) {
        return roomBookingRepository.save(roomBooking);
    }

    @Override
    public List<RoomBooking> getAllRoomBookings() {
        return roomBookingRepository.findAll();
    }

    @Override
    public Optional<RoomBooking> getRoomBookingById(Long id) {
        return roomBookingRepository.findById(id);
    }

    @Override
    public RoomBooking updateRoomBooking(Long id, RoomBooking roomBooking) {
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
            return roomBookingRepository.save(updatedBooking);
        } else {
            return null;
        }
    }

    @Override
    public void deleteRoomBooking(Long id) {
        roomBookingRepository.deleteById(id);
    }
}
