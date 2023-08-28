package com.hyperbank.loans.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "interest_rate_fixed")
public class InterestRateFixed {

	@Id
	@Column(name = "id_interest_rate", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "percentage", nullable = false, precision = 5, scale = 2)
	private BigDecimal percentage;
	
	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_interest_rate")
    @MapsId
	private InterestRate interestRate;

}