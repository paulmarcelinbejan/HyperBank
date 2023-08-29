package com.hyperbank.interest.interestratevariablehistory.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hyperbank.interest.interestratevariable.entity.InterestRateVariable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "interest_rate_variable_history")
public class InterestRateVariableHistory {

	@Id
	@Column(name = "id_interest_rate_variable_history", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	private InterestRateVariable interestRateVariable;

	@Column(name = "percentage", nullable = false, precision = 5, scale = 2)
	private BigDecimal percentage;

	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

}