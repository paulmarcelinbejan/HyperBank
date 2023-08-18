package com.hyperbank.commons.sextype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.commons.sextype.entity.SexType;

@Repository
public interface SexTypeRepository extends JpaRepository<SexType, Integer> {

}
