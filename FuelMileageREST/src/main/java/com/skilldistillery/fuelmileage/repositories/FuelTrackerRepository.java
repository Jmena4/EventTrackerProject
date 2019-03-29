package com.skilldistillery.fuelmileage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fuelmileage.entities.FuelTracker;

public interface FuelTrackerRepository extends JpaRepository<FuelTracker, Integer> {
	
	
}
