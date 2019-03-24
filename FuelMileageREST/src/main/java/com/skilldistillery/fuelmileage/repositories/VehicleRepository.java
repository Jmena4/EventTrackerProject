package com.skilldistillery.fuelmileage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fuelmileage.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
