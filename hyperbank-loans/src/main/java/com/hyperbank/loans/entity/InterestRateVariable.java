package com.hyperbank.loans.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "interest_rate_variable")
public class InterestRateVariable {

	@Id
	@Column(name = "id_interest_rate", nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_interest_rate")
    @MapsId
	private InterestRate interestRate;
	
}