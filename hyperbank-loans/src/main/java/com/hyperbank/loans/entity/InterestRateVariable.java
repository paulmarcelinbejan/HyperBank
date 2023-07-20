package com.hyperbank.loans.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "interest_rate_variable")
public class InterestRateVariable {

	@Id
	@Column(name = "id_interest_rate_variable", nullable = false)
	private Integer id;

}