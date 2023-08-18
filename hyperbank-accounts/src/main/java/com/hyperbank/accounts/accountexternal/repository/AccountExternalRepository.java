package com.hyperbank.accounts.accountexternal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.accounts.accountexternal.entity.AccountExternal;

@Repository
public interface AccountExternalRepository extends JpaRepository<AccountExternal, Long> {

	Optional<AccountExternal> findByIban(String iban);
	
}
