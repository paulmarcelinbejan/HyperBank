package com.hyperbank.interests.interestratevariablehistory.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "interest_rate_variable_history")
public class InterestRateVariableHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_interest_rate_variable_history_seq")
	@SequenceGenerator(name = "id_interest_rate_variable_history_seq", sequenceName = "id_interest_rate_variable_history_seq", allocationSize = 1)
	@Column(name = "id_interest_rate_variable_history", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_interest_rate_variable", nullable=false)
	private InterestRateVariable interestRateVariable;

	@Column(name = "percentage", nullable = false, precision = 5, scale = 2)
	private BigDecimal percentage;

	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

}