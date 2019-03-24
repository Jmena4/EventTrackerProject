package com.skilldistillery.fuelmileage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fuelmileage.entities.Fuel;

public interface FuelRepository extends JpaRepository<Fuel, Integer> {
	
	
}
