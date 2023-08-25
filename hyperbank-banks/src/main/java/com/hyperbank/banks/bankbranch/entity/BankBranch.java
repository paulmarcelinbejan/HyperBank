package com.hyperbank.banks.bankbranch.entity;

import com.hyperbank.banks.bank.entity.Bank;

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
@Table(name = "bank_branch")
public class BankBranch {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_bank_branch_seq")
	@SequenceGenerator(name = "id_bank_branch_seq", sequenceName = "id_bank_branch_seq", allocationSize = 1)
	@Column(name = "id_bank_branch", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_bank", nullable = false)
	private Bank bank;

	@Column(name = "fk_location", nullable = false)
	private Long locationId;

}