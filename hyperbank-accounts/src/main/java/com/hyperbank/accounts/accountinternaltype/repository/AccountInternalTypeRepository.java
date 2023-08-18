package com.hyperbank.accounts.accountinternaltype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.accounts.accountinternaltype.entity.AccountInternalType;

@Repository
public interface AccountInternalTypeRepository extends JpaRepository<AccountInternalType, Integer> {

}
