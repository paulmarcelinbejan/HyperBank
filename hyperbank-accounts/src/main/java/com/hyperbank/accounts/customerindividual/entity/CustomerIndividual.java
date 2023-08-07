package com.hyperbank.accounts.customerindividual.entity;

import java.time.LocalDate;

import com.hyperbank.commonentities.entity.SexType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "customer_individual")
public class CustomerIndividual {

	@Id
	@Column(name = "id_customer_individual", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "fk_nationality", nullable = false)
	private Integer fkNationality;

	@NotNull
	@Column(name = "fk_residence", nullable = false)
	private Long fkResidence;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_sex_type", nullable = false)
	private SexType fkSexType;

	@NotNull
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@NotNull
	@Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
	private String name;

	@NotNull
	@Column(name = "surname", nullable = false, length = Integer.MAX_VALUE)
	private String surname;

	@NotNull
	@Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
	private String email;

	@NotNull
	@Column(name = "phone_number", nullable = false, length = Integer.MAX_VALUE)
	private String phoneNumber;

}