package com.hyperbank.accounts.customerindividual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.accounts.customerindividual.entity.CustomerIndividual;

@Repository
public interface CustomerIndividualRepository extends JpaRepository<CustomerIndividual, Long> {

}
