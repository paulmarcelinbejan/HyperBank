package com.hyperbank.accounts.accountexternal.entity;

import com.hyperbank.accounts.account.entity.Account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "account_external")
public class AccountExternal {

	@Id
	@Column(name = "id_account", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "fk_bank", nullable = false)
	private Integer fkBank;

	@NotNull
	@Column(name = "iban", unique = true, nullable = false)
	private String iban;

	@NotNull
	@Column(name = "name", nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_account")
    @MapsId
	private Account account;
	
}