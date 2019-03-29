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

import com.skilldistillery.fuelmileage.entities.FuelTracker;
import com.skilldistillery.fuelmileage.services.FuelTrackerService;

@RestController
@RequestMapping("api")
public class FuelTrackerController {

	@Autowired
	private FuelTrackerService fuelTrackerService;

	@GetMapping("fuelTrackers")
	public List<FuelTracker> index() {
		return fuelTrackerService.findAll();
	}

	@GetMapping("fuelTrackers/{fid}")
	public Optional<FuelTracker> show(@PathVariable("fid") Integer id) {
		return fuelTrackerService.showFuelById(id);
	}

	@PostMapping("fuelTrackers")
	public FuelTracker createFuel(@RequestBody FuelTracker fuel, HttpServletRequest request,
			HttpServletResponse response) {
		fuel = fuelTrackerService.createFuelObject(fuel);
		response.setStatus(201);
		if (fuel == null) {
			response.setStatus(404);
		}

		return fuel;
	}

	@PutMapping("fuelTrackers/{fid}")
	public FuelTracker updateFuel(@PathVariable("fid") Integer id, @RequestBody FuelTracker fuel,
			HttpServletRequest request, HttpServletResponse response) {
		fuel = fuelTrackerService.updateFuelById(id, fuel);
		if (fuel == null) {
			response.setStatus(404);
		}
		return fuel;
	}

	@DeleteMapping("fuelTrackers/{id}")
	public void deleteFuel(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {
		if (fuelTrackerService.deleteById(id)) {
			response.setStatus(204);
		} else {
			response.setStatus(404);
		}
	}
}
