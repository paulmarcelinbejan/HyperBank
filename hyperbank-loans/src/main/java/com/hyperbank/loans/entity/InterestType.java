package com.hyperbank.loans.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "interest_type")
public class InterestType {

	@Id
	@Column(name = "id_interest_type", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "code", nullable = false, length = Integer.MAX_VALUE)
	private String code;

	@NotNull
	@Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
	private String description;

}