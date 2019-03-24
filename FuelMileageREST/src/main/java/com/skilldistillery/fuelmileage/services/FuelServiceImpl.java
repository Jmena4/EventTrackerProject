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
	public Optional<Fuel> showFuelById(int id) {
		Optional<Fuel> showFuel =fuelRepo.findById(id);
		return showFuel;
	}

	@Override
	public Fuel createFuelObject(Fuel fuel) {
		Fuel createFuel = fuelRepo.saveAndFlush(fuel);
		return createFuel;
	}

	@Override
	public Fuel updateFuelById(int id, Fuel fuel) {
		Optional<Fuel> opt = fuelRepo.findById(id);
		if (opt.isPresent()) {
			Fuel managedFuel = opt.get();
			managedFuel.setGallons(fuel.getGallons());
			managedFuel.setPricePerGallon(fuel.getPricePerGallon());
			managedFuel.setTotalPrice(fuel.getTotalPrice());
			managedFuel.setEstimatedMiles(fuel.getEstimatedMiles());
			managedFuel.setOdometerReading(fuel.getOdometerReading());
			managedFuel.setVehicle(fuel.getVehicle());
			fuelRepo.saveAndFlush(managedFuel);
			return managedFuel;
		}
		return null;
	}

	@Override
	public Fuel replaceFuelById(int id, Fuel fuel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(int fuelId) {
		boolean deleted = false;
		if (fuelRepo.existsById(fuelId)) {
			fuelRepo.deleteById(fuelId);
			deleted = true;
		}
		return deleted;
	}
}
