package com.hyperbank.accounts.accountexternal.service;

import java.util.List;

import com.hyperbank.accounts.accountexternal.entity.AccountExternal;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

public interface AccountExternalService {

	/**
	 * Returns a reference to the entity with the given identifier.
	 */
	AccountExternal getReferenceById(Long id);
	
	AccountExternal findById(Long id) throws FunctionalException;

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	List<AccountExternal> findManyById(List<Long> ids) throws FunctionalException;

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	List<AccountExternal> findManyByIdIfPresent(List<Long> ids);

	List<AccountExternal> findAll();

	Long save(AccountExternal entity) throws FunctionalException;
	
	List<Long> save(List<AccountExternal> entities) throws FunctionalException;
	
	AccountExternal saveAndReturn(AccountExternal entity) throws FunctionalException;
	
	List<AccountExternal> saveAndReturn(List<AccountExternal> entities) throws FunctionalException;
	
	/**
	 * If the Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	void delete(Long id) throws FunctionalException;

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	void deleteMany(List<Long> ids) throws FunctionalException;
	
	/**
	 * If the Entity is not present in the persistence store, it will be silently ignored.
	 */
	void deleteIfPresent(Long id);

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	void deleteManyIfPresent(List<Long> ids);
	
}
