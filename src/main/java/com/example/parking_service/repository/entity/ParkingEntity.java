package com.example.parking_service.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="parking_service")
public class ParkingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="parking_id")
	private int parkingId;
	
	@Column(name="parking_number",unique = true)
	private String parkingNumber;
	
	@Column(name="parking_building")
	private String parkingBuilding;
	
	@Column(name="parking_floor")
	private String parkingFloor;
	
	@Column(name="parking_type")
	private String parkingType;
	
	@Column(name="parking_available")
	private boolean parkingAvailable;

}
