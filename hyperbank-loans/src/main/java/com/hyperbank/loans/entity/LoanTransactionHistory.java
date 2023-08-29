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
@Table(name = "loan_transaction_history")
public class LoanTransactionHistory {

	@Id
	@Column(name = "id_loan_transaction_history", nullable = false)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_loan_history", nullable = false)
	private LoanHistory loanHistory;

	@Column(name = "fk_interest_rate", nullable = false)
	private Long interestRateId;

	@NotNull
	@Column(name = "fk_transaction", nullable = false)
	private Long fkTransaction;

	@NotNull
	@Column(name = "total_amount", nullable = false, precision = 8, scale = 2)
	private BigDecimal totalAmount;

	@NotNull
	@Column(name = "interest_amount", nullable = false, precision = 8, scale = 2)
	private BigDecimal interestAmount;

	@NotNull
	@Column(name = "service_fee", nullable = false, precision = 6, scale = 2)
	private BigDecimal serviceFee;

}