package com.skilldistillery.fuelmileage.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.fuelmileage.entities.Vehicle;

public interface VehicleService {

	public List<Vehicle>findAll();
	
	public Optional<Vehicle> showVehicleById(int id);
	
	public Vehicle createVehicleObject(Vehicle vehicle) ;
	
	public Vehicle updateVehicleById(int id, Vehicle vehicle);
	
	public Vehicle replaceVehicleById(int id, Vehicle vehicle);
	
	public Boolean deleteById(int id);
}
