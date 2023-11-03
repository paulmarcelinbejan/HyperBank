package com.hyperbank.loans.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "loan_type")
public class LoanType {

	@Id
	@Column(name = "id_loan_type", nullable = false)
	private Integer id;

	@Column(name = "code", nullable = false, length = Integer.MAX_VALUE)
	private String code;

	@Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
	private String description;

}