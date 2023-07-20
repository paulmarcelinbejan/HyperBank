package com.hyperbank.banks.bankbranch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.banks.bankbranch.entity.BankBranch;

@Repository
public interface BankBranchRepository extends JpaRepository<BankBranch, Integer> {

}
