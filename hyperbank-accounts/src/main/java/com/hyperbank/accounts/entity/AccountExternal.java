package com.hyperbank.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "account_external")
public class AccountExternal {

	@Id
	@Column(name = "id_account_external", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "fk_bank", nullable = false)
	private Integer fkBank;

	@NotNull
	@Column(name = "iban", nullable = false, length = Integer.MAX_VALUE)
	private String iban;

	@NotNull
	@Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
	private String name;

}