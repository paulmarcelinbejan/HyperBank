package com.hyperbank.accounts.accountinternal.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hyperbank.accounts.account.entity.Account;
import com.hyperbank.accounts.accountinternaltype.entity.AccountInternalType;
import com.hyperbank.accounts.customer.entity.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_internal")
public class AccountInternal {

	@Id
	@Column(name = "id_account", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_customer", nullable = false)
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_account_internal_type", nullable = false)
	private AccountInternalType accountInternalType;
	
	@Column(name = "fk_currency", nullable = false)
	private Integer currencyId;
	
	@Column(name = "balance", nullable = false, precision = 12, scale = 2)
	private BigDecimal balance;

	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;
	
	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_account")
    @MapsId
	private Account account;

}