package com.hyperbank.accounts.accounttype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.accounts.accounttype.entity.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {

}
