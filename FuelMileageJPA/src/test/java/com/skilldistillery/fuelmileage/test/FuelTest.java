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

@DisplayName("Fuel Entity Tests")
class FuelTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Fuel fuel;

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
		fuel = em.find(Fuel.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		fuel = null;
	}

	@Test
	void test_fuel_mapping() {
		assertEquals("2016-06-30", fuel.getDate().toString());
		assertEquals(5.18, fuel.getGallons().doubleValue());
		assertEquals(1.939, fuel.getPricePerGallon().doubleValue());
		assertEquals(10.04, fuel.getTotalPrice().doubleValue());
		assertEquals(169, fuel.getEstimatedMiles().intValue());
		assertEquals(1, fuel.getOdometerReading());
		assertEquals(1, fuel.getVehicle().getId());
	}

}
