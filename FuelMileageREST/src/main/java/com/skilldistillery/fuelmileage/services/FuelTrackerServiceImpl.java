package com.skilldistillery.fuelmileage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.fuelmileage.entities.FuelTracker;
import com.skilldistillery.fuelmileage.repositories.FuelTrackerRepository;

@Service
public class FuelTrackerServiceImpl implements FuelTrackerService {

	@Autowired
	private FuelTrackerRepository fuelTrackerRepo;

	@Override
	public List<FuelTracker> findAll() {
		return fuelTrackerRepo.findAll();
	}

	@Override
	public Optional<FuelTracker> showFuelById(int id) {
		Optional<FuelTracker> showFuel =fuelTrackerRepo.findById(id);
		return showFuel;
	}

	@Override
	public FuelTracker createFuelObject(FuelTracker fuel) {
		FuelTracker createFuel = fuelTrackerRepo.saveAndFlush(fuel);
		return createFuel;
	}

	@Override
	public FuelTracker updateFuelById(int id, FuelTracker fuel) {
		Optional<FuelTracker> opt = fuelTrackerRepo.findById(id);
		if (opt.isPresent()) {
			FuelTracker managedFuel = opt.get();
			managedFuel.setGallons(fuel.getGallons());
			managedFuel.setPricePerGallon(fuel.getPricePerGallon());
			managedFuel.setTotalPrice(fuel.getTotalPrice());
			managedFuel.setEstimatedMiles(fuel.getEstimatedMiles());
			managedFuel.setOdometerReading(fuel.getOdometerReading());
			managedFuel.setVehicle(fuel.getVehicle());
			fuelTrackerRepo.saveAndFlush(managedFuel);
			return managedFuel;
		}
		return null;
	}

	@Override
	public FuelTracker replaceFuelById(int id, FuelTracker fuel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(int fuelId) {
		boolean deleted = false;
		if (fuelTrackerRepo.existsById(fuelId)) {
			fuelTrackerRepo.deleteById(fuelId);
			deleted = true;
		}
		return deleted;
	}
}
