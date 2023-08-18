package com.hyperbank.accounts.account.entity;

import com.hyperbank.accounts.accountexternal.entity.AccountExternal;
import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.hyperbank.accounts.accounttype.entity.AccountType;

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
@Table(name = "account")
public class Account {

	@Id
	@Column(name = "id_account", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_account_type", nullable = false)
	private AccountType accountType;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@MapsId
	private AccountInternal accountInternal;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@MapsId
	private AccountExternal accountExternal;

}