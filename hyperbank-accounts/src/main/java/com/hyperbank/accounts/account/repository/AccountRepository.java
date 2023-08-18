package com.hyperbank.accounts.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.accounts.account.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
