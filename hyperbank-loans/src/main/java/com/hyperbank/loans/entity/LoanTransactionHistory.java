package com.hyperbank.loans.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_transaction_history")
public class LoanTransactionHistory {

	@Id
	@Column(name = "id_loan_transaction_history", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_loan_history", nullable = false)
	private LoanHistory loanHistory;

	@Column(name = "fk_interest_rate", nullable = false)
	private Long interestRateId;

	@Column(name = "fk_transaction", nullable = false)
	private Long fkTransaction;

	@Column(name = "total_amount", nullable = false, precision = 8, scale = 2)
	private BigDecimal totalAmount;

	@Column(name = "interest_amount", nullable = false, precision = 8, scale = 2)
	private BigDecimal interestAmount;

	@Column(name = "service_fee", nullable = false, precision = 6, scale = 2)
	private BigDecimal serviceFee;

}