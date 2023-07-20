package com.hyperbank.accounts.entity;

import java.time.LocalDate;

import com.hyperbank.commonentities.entity.Currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "account_internal")
public class AccountInternal {

	@Id
	@Column(name = "id_account_internal", nullable = false)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_customer", nullable = false)
	private Customer fkCustomer;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_account_type", nullable = false)
	private AccountType fkAccountType;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_currency", nullable = false)
	private Currency fkCurrency;

	@NotNull
	@Column(name = "iban", nullable = false, length = Integer.MAX_VALUE)
	private String iban;

	@NotNull
	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@NotNull
	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

}