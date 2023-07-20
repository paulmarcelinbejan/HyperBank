package com.hyperbank.banks.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.banks.bank.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

}
