package com.hyperbank.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@Column(name = "id_account", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_account_type")
	private AccountType accountType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_account_internal")
	private AccountInternal fkAccountInternal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_account_external")
	private AccountExternal fkAccountExternal;

}