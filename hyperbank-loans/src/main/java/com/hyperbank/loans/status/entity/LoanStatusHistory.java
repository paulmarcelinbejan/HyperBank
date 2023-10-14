package com.hyperbank.loans.status.entity;

import java.time.Instant;

import com.hyperbank.loans.entity.Loan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "loan_status_history")
public class LoanStatusHistory {

	@Id
	@Column(name = "id_loan_status_history", nullable = false)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_loan", nullable = false)
	private Loan fkLoan;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_loan_status", nullable = false)
	private LoanStatus loanStatus;

	@NotNull
	@Column(name = "start_date_time", nullable = false)
	private Instant startDateTime;

	@NotNull
	@Column(name = "end_date_time", nullable = false)
	private Instant endDateTime;

}