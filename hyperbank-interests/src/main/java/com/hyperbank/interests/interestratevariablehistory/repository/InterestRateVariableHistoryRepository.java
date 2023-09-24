package com.hyperbank.interests.interestratevariablehistory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;

@Repository
public interface InterestRateVariableHistoryRepository extends JpaRepository<InterestRateVariableHistory, Long> {

	@Query("""
           FROM InterestRateVariableHistory
           WHERE interestRateVariable.id = :interestRateVariableId
           ORDER BY startDate DESC
           LIMIT 1
    """)
	Optional<InterestRateVariableHistory> findFirstByInterestRateVariableOrderByStartDateDesc(@Param("interestRateVariableId") Long interestRateVariableId);
	
}
