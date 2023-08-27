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
import lombok.Data;

@Data
@Entity
@Table(name = "account_external")
public class AccountExternal {

	@Id
	@Column(name = "id_account", nullable = false)
	private Long id;

	@Column(name = "fk_bank", nullable = false)
	private Integer fkBank;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_account")
    @MapsId
	private Account account;
	
}