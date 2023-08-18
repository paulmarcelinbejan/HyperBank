package com.hyperbank.accounts.accountinternal.entity;

import java.time.LocalDate;

import com.hyperbank.accounts.accountinternaltype.entity.AccountInternalType;
import com.hyperbank.accounts.customer.entity.Customer;
import com.hyperbank.commons.currency.entity.Currency;

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
@Table(name = "account_internal")
public class AccountInternal {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_account_seq")
	@SequenceGenerator(name = "id_account_seq", sequenceName = "id_account_seq", allocationSize = 1)
	@Column(name = "id_account_internal", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_customer", nullable = false)
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_account_internal_type", nullable = false)
	private AccountInternalType accountInternalType;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_currency", nullable = false)
	private Currency currency;

	@Column(name = "iban", unique = true, nullable = false)
	private String iban;

	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

}