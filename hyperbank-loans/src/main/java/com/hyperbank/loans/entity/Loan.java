package com.hyperbank.loans.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@Column(name = "id_loan", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "fk_customer", nullable = false)
	private Long fkCustomer;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_loan_type", nullable = false)
	private LoanType fkLoanType;

	@NotNull
	@Column(name = "loan_principal", nullable = false, precision = 12, scale = 2)
	private BigDecimal loanPrincipal;

}