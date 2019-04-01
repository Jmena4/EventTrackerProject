package com.skilldistillery.fuelmileage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.fuelmileage.entities.FuelTracker;
import com.skilldistillery.fuelmileage.entities.Vehicle;

public interface FuelTrackerRepository extends JpaRepository<FuelTracker, Integer> {
	
//	@Query("SELECT v FROM Vehicle v JOIN FETCH v.fuel WHERE v.id = :vid")
//	Vehicle queryForVehicleByFuelTrackerId(@Param("vid") Integer id);
	
	@Query("SELECT f FROM FuelTracker f JOIN FETCH f.vehicle WHERE f.id = :fid")
	Vehicle queryForVehicleByFuelTrackerId(@Param("fid") Integer id);
	
	
}
