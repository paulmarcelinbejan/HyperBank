package com.hyperbank.accounts.account.service;

import java.util.List;

import com.hyperbank.accounts.account.entity.Account;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;

public interface AccountService {

	/**
	 * Returns a reference to the entity with the given identifier.
	 */
	Account getReferenceById(Long id);
	
	Account findById(Long id) throws FunctionalException;

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException will be thrown.
	 */
	List<Account> findManyById(List<Long> ids) throws FunctionalException;

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	List<Account> findManyByIdIfPresent(List<Long> ids);

	List<Account> findAll();
	
	Account saveWithAccountInternalType() throws FunctionalException;
	
	Account saveWithAccountExternalType() throws FunctionalException;
	
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
