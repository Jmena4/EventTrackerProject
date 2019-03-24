package com.skilldistillery.fuelmileage.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.fuelmileage.entities.Vehicle;
import com.skilldistillery.fuelmileage.services.VehicleService;

@RestController
@RequestMapping("api")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("ping2")
	public String ping() {
		return "pong2";
	}

	@GetMapping("vehicles")
	public List<Vehicle> index() {
		return vehicleService.findAll();
	}

	@GetMapping("vehicles/{id}")
	public Optional<Vehicle> getById(@PathVariable("id") Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		return vehicleService.showVehicleById(id);
	}

	@PostMapping("vehicles")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle, HttpServletResponse response,
			HttpServletRequest request) {
		vehicle = vehicleService.createVehicleObject(vehicle);

		if (vehicle == null) {
			response.setStatus(404);
		}

		return vehicle;
	}

	@PutMapping("vehicles/{id}")
	public Vehicle updateVehicle(@PathVariable("id") Integer id, @RequestBody Vehicle vehicle, HttpServletRequest request,
			HttpServletResponse response) {
		vehicle = vehicleService.updateVehicleById(id, vehicle);
		if (vehicle == null) {
			response.setStatus(404);
		}

		return vehicle;
	}

	@DeleteMapping("vehicles/{id}")
	public void deleteVehicle(@PathVariable("id") Integer id, HttpServletResponse response) {
		if (vehicleService.deleteById(id)) {
			response.setStatus(204);

		} else {
			response.setStatus(404);
		}
	}

}
