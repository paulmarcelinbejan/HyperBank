package com.hyperbank.banks.bank.entity;

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
@Table(name = "bank")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_bank_seq")
	@SequenceGenerator(name = "id_bank_seq", sequenceName = "id_bank_seq", allocationSize = 1)
	@Column(name = "id_bank", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "bank_name", nullable = false, length = Integer.MAX_VALUE)
	private String bankName;

}