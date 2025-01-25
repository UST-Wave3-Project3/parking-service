package com.example.parking_service.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking_service.repository.entity.ParkingEntity;
import com.example.parking_service.service.ParkingService;

@RestController
@RequestMapping("/api/parkings")
public class ParkingController {
	
	@Autowired
	private ParkingService parkingService;
	
	@GetMapping
	public ResponseEntity<List<ParkingEntity>> getAllParkings(){
		return new ResponseEntity<List<ParkingEntity>>(parkingService.getAllParkingSlots(),HttpStatus.OK);
	}
	
	@GetMapping("/{parkingId}")
    public ResponseEntity<Optional<ParkingEntity>> getParkingById(@PathVariable int parkingId) {
        // Logic to fetch parking by ID
        return new ResponseEntity<Optional<ParkingEntity>>(parkingService.getParkingById(parkingId),HttpStatus.OK);
    }
	
	@PostMapping
	public ResponseEntity<ParkingEntity> addParkingSlot(@RequestBody ParkingEntity newParkingSlot){
		return new ResponseEntity<ParkingEntity>(parkingService.addParkingSlot(newParkingSlot),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ParkingEntity> updateParkingSlot(@RequestBody ParkingEntity editParkingSlot){
		return new ResponseEntity<ParkingEntity>(parkingService.addParkingSlot(editParkingSlot),HttpStatus.OK);
	}
	
	@DeleteMapping("/{pId}")
	public ResponseEntity<Void> deleteParkingSlot(@PathVariable int pId){
		parkingService.deleteParkingSlot(pId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/slots")
	public ResponseEntity<List<ParkingEntity>> getParkingSlotsByAvailability(@RequestParam("parkingAvailable") boolean availability){
		return new ResponseEntity<List<ParkingEntity>>(parkingService.getParkingSlotsByAvailability(availability),HttpStatus.OK);
	}
	
	@GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getParkingCounts() {
        Map<String, Long> stats = parkingService.getParkingStatistics();
        return ResponseEntity.ok(stats);
    }
	
	
	
	

}
