package com.hyperbank.staff.entity;

import java.time.LocalDate;

import com.hyperbank.commons.sextype.entity.SexType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_employee_seq")
	@SequenceGenerator(name = "id_employee_seq", sequenceName = "id_employee_seq", allocationSize = 1)
	@Column(name = "id_employee", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "fk_nationality", nullable = false)
	private Integer fkNationality;

	@NotNull
	@Column(name = "fk_residence", nullable = false)
	private Long fkResidence;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_sex_type", nullable = false)
	private SexType sexType;

	@NotNull
	@Column(name = "fk_bank_branch", nullable = false)
	private Integer fkBankBranch;

	@NotNull
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@NotBlank
	@Column(name = "name", nullable = false)
	private String name;

	@NotBlank
	@Column(name = "surname", nullable = false)
	private String surname;

	@NotBlank
	@Column(name = "email", nullable = false)
	private String email;

	@NotBlank
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

}