package com.example.parking_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.parking_service.repository.entity.ParkingEntity;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Integer> {
	
	List<ParkingEntity> findByParkingAvailable(boolean parkingAvailable);
	
	@Query("SELECT COUNT(p) FROM ParkingEntity p")
    long countTotalSlots();

    @Query("SELECT COUNT(p) FROM ParkingEntity p WHERE p.parkingAvailable = true")
    long countAvailableSlots();

    @Query("SELECT COUNT(p) FROM ParkingEntity p WHERE p.parkingAvailable = false")
    long countUnavailableSlots();

    @Query("SELECT COUNT(p) FROM ParkingEntity p WHERE p.parkingType = '2-wheeler'")
    long countTwoWheelerSlots();

    @Query("SELECT COUNT(p) FROM ParkingEntity p WHERE p.parkingType = '4-wheeler'")
    long countFourWheelerSlots();

}
