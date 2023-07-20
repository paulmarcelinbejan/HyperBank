package com.hyperbank.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "customer_legal_entity")
public class CustomerLegalEntity {

	@Id
	@Column(name = "id_customer_legal_entity", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "fk_headquarters", nullable = false)
	private Long fkHeadquarters;

	@NotNull
	@Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
	private String name;

}