package edu.uow.ap.roombooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uow.ap.roombooking.entity.RoomBooking;

@Repository
public interface RoomBookingRepository extends JpaRepository<RoomBooking,Long>{

}
