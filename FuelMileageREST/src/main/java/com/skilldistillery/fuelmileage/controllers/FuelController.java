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

import com.skilldistillery.fuelmileage.entities.Fuel;
import com.skilldistillery.fuelmileage.services.FuelService;

@RestController
@RequestMapping("api")
public class FuelController {

	@Autowired
	private FuelService fuelService;

	@GetMapping("ping")
	public String ping() {
		return "pong";
	}

	@GetMapping("fuels")
	public List<Fuel> index() {
		return fuelService.findAll();
	}

	@GetMapping("fuels/{fid}")
	public Optional<Fuel> show(@PathVariable("fid") Integer id) {
		return fuelService.showFuelById(id);
	}

	@PostMapping("fuels")
	public Fuel createFuel(@RequestBody Fuel fuel, HttpServletRequest request, HttpServletResponse response) {
		fuel = fuelService.createFuelObject(fuel);

		if (fuel == null) {
			response.setStatus(404);
		}

		return fuel;
	}

	@PutMapping("fuels/{fid}")
	public Fuel updateFuel(@PathVariable("fid") Integer id, @RequestBody Fuel fuel, HttpServletRequest request,
			HttpServletResponse response) {
		fuel = fuelService.updateFuelById(id, fuel);
		if (fuel == null) {
			response.setStatus(404);
		}
		return fuel;
	}

	@DeleteMapping("fuels/{id}")
	public void deleteFuel(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {
		if (fuelService.deleteById(id)) {
			response.setStatus(204);
		} else {
			response.setStatus(404);
		}
	}
}
