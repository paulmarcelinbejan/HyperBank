package com.hyperbank.accounts.accountinternal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.accounts.accountinternal.entity.AccountInternal;

@Repository
public interface AccountInternalRepository extends JpaRepository<AccountInternal, Long> {

}
