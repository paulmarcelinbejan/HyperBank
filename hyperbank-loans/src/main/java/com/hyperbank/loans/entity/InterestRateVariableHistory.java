package com.hyperbank.loans.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "interest_rate_variable_history")
public class InterestRateVariableHistory {

	@Id
	@Column(name = "id_interest_rate_variable_history", nullable = false)
	private Integer id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_interest_rate_variable", nullable = false)
	private InterestRateVariable fkInterestRateVariable;

	@NotNull
	@Column(name = "percentage", nullable = false, precision = 5, scale = 2)
	private BigDecimal percentage;

	@NotNull
	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@NotNull
	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

}