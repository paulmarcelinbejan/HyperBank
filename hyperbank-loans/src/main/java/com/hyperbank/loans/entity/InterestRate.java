package com.hyperbank.loans.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "interest_rate")
public class InterestRate {

	@Id
	@Column(name = "id_interest_rate", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_interest_type")
	private InterestType interestType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_interest_rate_fixed")
	private InterestRateFixed fkInterestRateFixed;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_interest_rate_variable")
	private InterestRateVariable fkInterestRateVariable;

}