package com.hyperbank.accounts.customertype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.accounts.customertype.entity.CustomerType;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {

}
