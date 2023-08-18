package com.hyperbank.accounts.accountexternal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "account_external")
public class AccountExternal {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_account_seq")
	@SequenceGenerator(name = "id_account_seq", sequenceName = "id_account_seq", allocationSize = 1)
	@Column(name = "id_account_external", nullable = false)
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

}