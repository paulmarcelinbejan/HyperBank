package com.hyperbank.maps.continent.service;

import java.util.List;

import com.hyperbank.maps.continent.entity.Continent;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

public interface ContinentService {

	// CREATE 

	Integer save(Continent entity) throws FunctionalException;
	
	List<Integer> save(List<Continent> entities) throws FunctionalException;

	Continent saveAndReturn(Continent entity) throws FunctionalException;
	
	List<Continent> saveAndReturn(List<Continent> entities) throws FunctionalException;

	// READ 

	/**
	 * Returns a reference to the entity with the given identifier.
	 */
	Continent getReferenceById(Integer id);
	
	Continent findById(Integer id) throws FunctionalException;

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	List<Continent> findManyById(List<Integer> ids) throws FunctionalException;

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	List<Continent> findManyByIdIfPresent(List<Integer> ids);

	List<Continent> findAll();

	// UPDATE 

	Integer update(Continent entity) throws FunctionalException;
	
	List<Integer> update(List<Continent> entities) throws FunctionalException;

	Continent updateAndReturn(Continent entity) throws FunctionalException;
	
	List<Continent> updateAndReturn(List<Continent> entities) throws FunctionalException;

	// DELETE 

	/**
	 * If the Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	void delete(Integer id) throws FunctionalException;

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	void deleteMany(List<Integer> ids) throws FunctionalException;

	/**
	 * If the Entity is not present in the persistence store, it will be silently ignored.
	 */
	void deleteIfPresent(Integer id);

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	void deleteManyIfPresent(List<Integer> ids);

}
