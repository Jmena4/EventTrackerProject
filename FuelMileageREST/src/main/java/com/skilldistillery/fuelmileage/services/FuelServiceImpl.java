package com.skilldistillery.fuelmileage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.fuelmileage.entities.Fuel;
import com.skilldistillery.fuelmileage.repositories.FuelRepository;

@Service
public class FuelServiceImpl implements FuelService {

	@Autowired
	private FuelRepository fuelRepo;

	@Override
	public List<Fuel> findAll() {
		return fuelRepo.findAll();
	}

	@Override
	public Fuel findById(int id) {
		return fuelRepo.findById(id);
	}

	@Override
	public Fuel createFuelObject(Fuel fuel) {
		Fuel createFuel = fuelRepo.saveAndFlush(fuel);
		return createFuel;
	}

	@Override
	public Fuel updateFuelById(int id, Fuel fuel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fuel replaceFuelById(int id, Fuel fuel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteFuelById(int fuelId, Fuel fuel) {
		boolean deleted = false;
		
		 fuelRepo.deleteById(fuelId);
		return null;
	}
}
