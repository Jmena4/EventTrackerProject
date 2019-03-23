package com.skilldistillery.fuelmileage.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Transactional
@Service
public class FuelDaoImpl implements FuelDAO {
	@PersistenceContext
	private EntityManager em;



}
