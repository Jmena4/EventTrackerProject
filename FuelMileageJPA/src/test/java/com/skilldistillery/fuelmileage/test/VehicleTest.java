package com.skilldistillery.fuelmileage.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.fuelmileage.entities.Fuel;
import com.skilldistillery.fuelmileage.entities.Vehicle;

@DisplayName("Vehicle Entity Test")
class VehicleTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Vehicle vehicle;

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
		vehicle = em.find(Vehicle.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		vehicle = null;
	}

	@Test
	void test_vehicle_mapping() {
		assertEquals("xter", vehicle.getVin());
		assertEquals(2012, vehicle.getYear().intValue());
		assertEquals("Nissan", vehicle.getMake());
		assertEquals("Xterra Pro-4x", vehicle.getModel());
	}

}
