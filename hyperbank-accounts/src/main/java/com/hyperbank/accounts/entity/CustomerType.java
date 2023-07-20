package com.hyperbank.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "customer_type")
public class CustomerType {

	@Id
	@Column(name = "id_customer_type", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "code", nullable = false, length = Integer.MAX_VALUE)
	private String code;

	@NotNull
	@Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
	private String description;

}