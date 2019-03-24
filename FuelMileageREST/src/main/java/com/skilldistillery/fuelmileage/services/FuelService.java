package com.skilldistillery.fuelmileage.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.fuelmileage.entities.Fuel;

public interface FuelService {
	
	public List<Fuel> findAll();

	public Optional<Fuel> showFuelById(int id);
	
	public Fuel createFuelObject(Fuel fuel);

	public Fuel updateFuelById(int id, Fuel fuel);

	public Fuel replaceFuelById(int id, Fuel fuel);

	public Boolean deleteById(int id);

}
