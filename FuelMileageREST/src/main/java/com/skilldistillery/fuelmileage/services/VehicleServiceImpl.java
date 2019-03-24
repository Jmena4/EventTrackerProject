package com.skilldistillery.fuelmileage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.fuelmileage.entities.Vehicle;
import com.skilldistillery.fuelmileage.repositories.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;

	@Override
	public List<Vehicle> findAll() {
		return vehicleRepo.findAll();
	}

	@Override
	public Optional<Vehicle> showVehicleById(int id) {
		Optional<Vehicle> showVehicle = vehicleRepo.findById(id);
		return showVehicle;
	}

	@Override
	public Vehicle createVehicleObject(Vehicle vehicle) {
		Vehicle createVehicle = vehicleRepo.saveAndFlush(vehicle);
		return createVehicle;
	}

	@Override
	public Vehicle updateVehicleById(int id, Vehicle vehicle) {
		Optional<Vehicle> opt = vehicleRepo.findById(id);
		if (opt.isPresent()) {
			Vehicle managedVehicle = opt.get();
			managedVehicle.setVin(vehicle.getVin());
			managedVehicle.setMake(vehicle.getMake());
			managedVehicle.setModel(vehicle.getModel());
			managedVehicle.setYear(vehicle.getYear());
			managedVehicle.setFuel(vehicle.getFuel());
			vehicleRepo.saveAndFlush(managedVehicle);
			return managedVehicle;
		}
		return null;
	}

	@Override
	public Vehicle replaceVehicleById(int id, Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(int id) {
		boolean deleted = false;
		if (vehicleRepo.existsById(id)) {
			vehicleRepo.deleteById(id);
			deleted = true;
		}
		return deleted;
	}

}
