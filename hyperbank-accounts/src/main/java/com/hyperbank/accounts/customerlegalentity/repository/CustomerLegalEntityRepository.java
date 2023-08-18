package com.hyperbank.accounts.customerlegalentity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.accounts.customerlegalentity.entity.CustomerLegalEntity;

@Repository
public interface CustomerLegalEntityRepository extends JpaRepository<CustomerLegalEntity, Long> {

}
