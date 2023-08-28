package com.hyperbank.accounts.depositaccountdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.accounts.depositaccountdetails.entity.DepositAccountDetails;

@Repository
public interface DepositAccountDetailsRepository extends JpaRepository<DepositAccountDetails, Long> {

}
