package com.example.parking_service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking_service.repository.ParkingRepository;
import com.example.parking_service.repository.entity.ParkingEntity;

@Service
public class ParkingService {
	
	@Autowired
	private ParkingRepository parkingRepository;
	
	public List<ParkingEntity> getAllParkingSlots(){
		return parkingRepository.findAll();
	}
	
	public ParkingEntity addParkingSlot(ParkingEntity newParkingSlot) {
		return parkingRepository.saveAndFlush(newParkingSlot);
	}
	
	public ParkingEntity updateParkingSlot(ParkingEntity editParkingSlot) {
		return parkingRepository.save(editParkingSlot);
	}
	
	public void deleteParkingSlot(int pId) {
		parkingRepository.deleteById(pId);
	}
	
	public List<ParkingEntity> getParkingSlotsByAvailability(boolean availability) {
        return parkingRepository.findByParkingAvailable(availability);
    }
	
	public Map<String, Long> getParkingStatistics() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalSlots", parkingRepository.countTotalSlots());
        stats.put("availableCount", parkingRepository.countAvailableSlots());
        stats.put("notAvailableCount", parkingRepository.countUnavailableSlots());
        stats.put("twoWheelerCount", parkingRepository.countTwoWheelerSlots());
        stats.put("fourWheelerCount", parkingRepository.countFourWheelerSlots());

        return stats;
    }
	
	public Optional<ParkingEntity> getParkingById(int parkingId) {
		return parkingRepository.findById(parkingId);
	}
}
