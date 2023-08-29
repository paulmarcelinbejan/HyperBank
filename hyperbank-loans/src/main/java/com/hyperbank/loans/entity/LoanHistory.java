package com.hyperbank.loans.entity;

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
@Table(name = "loan_history")
public class LoanHistory {

	@Id
	@Column(name = "id_loan_history", nullable = false)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_loan", nullable = false)
	private Loan fkLoan;

	@NotNull
	@Column(name = "fk_interest_type", nullable = false)
	private Integer interestRateTypeId;

	@NotNull
	@Column(name = "fk_bank_branch", nullable = false)
	private Integer fkBankBranch;

	@NotNull
	@Column(name = "loan_term", nullable = false)
	private Integer loanTerm;

	@NotNull
	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@NotNull
	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

}