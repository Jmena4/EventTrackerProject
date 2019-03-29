package com.skilldistillery.fuelmileage.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.fuelmileage.entities.FuelTracker;

public interface FuelTrackerService {
	
	public List<FuelTracker> findAll();

	public Optional<FuelTracker> showFuelById(int id);
	
	public FuelTracker createFuelObject(FuelTracker fuel);

	public FuelTracker updateFuelById(int id, FuelTracker fuel);

	public FuelTracker replaceFuelById(int id, FuelTracker fuel);

	public Boolean deleteById(int id);

}
