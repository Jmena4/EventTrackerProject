package com.skilldistillery.fuelmileage.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.fuelmileage.entities.FuelTracker;

@DisplayName("Fuel Entity Tests")
class FuelTrackerTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private FuelTracker fuelTracker;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("In BeforeAll");
		emf = Persistence.createEntityManagerFactory("FuelMileage");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		fuelTracker = em.find(FuelTracker.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		fuelTracker = null;
	}

	@Test
	void test_fuel_mapping() {
		assertEquals("2016-06-30", fuelTracker.getDate().toString());
		assertEquals(5.18, fuelTracker.getGallons().doubleValue());
		assertEquals(1.939, fuelTracker.getPricePerGallon().doubleValue());
		assertEquals(10.04, fuelTracker.getTotalPrice().doubleValue());
		assertEquals(169, fuelTracker.getEstimatedMiles().intValue());
		assertEquals(1, fuelTracker.getOdometerReading());
		assertEquals(1, fuelTracker.getVehicle().getId());
	}

}
