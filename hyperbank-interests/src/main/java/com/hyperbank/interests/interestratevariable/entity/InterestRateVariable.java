package com.hyperbank.interests.interestratevariable.entity;

import java.util.ArrayList;
import java.util.List;

import com.hyperbank.interests.interestrate.entity.InterestRate;
import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "interest_rate_variable")
public class InterestRateVariable {

	@Id
	@Column(name = "id_interest_rate", nullable = false)
	private Long id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_interest_rate")
    @MapsId
	private InterestRate interestRate;
	
	@OneToMany(
	    mappedBy = "interestRateVariable",
	    cascade = CascadeType.ALL,
	    orphanRemoval = true
	)
	@OrderBy("startDate")
	private List<InterestRateVariableHistory> history = new ArrayList<>();
	
	public InterestRateVariable addHistory(InterestRateVariableHistory interestRateVariableHistory) {
		interestRateVariableHistory.setInterestRateVariable(this);
		history.add(interestRateVariableHistory);
        return this;
    }
    
}