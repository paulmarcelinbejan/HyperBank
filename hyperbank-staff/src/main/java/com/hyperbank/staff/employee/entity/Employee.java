package com.hyperbank.staff.employee.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_employee_seq")
	@SequenceGenerator(name = "id_employee_seq", sequenceName = "id_employee_seq", allocationSize = 1)
	@Column(name = "id_employee", nullable = false)
	private Long id;

	@Column(name = "fk_nationality", nullable = false)
	private Integer nationalityId;

	@Column(name = "fk_residence", nullable = false)
	private Long residenceId;

	@Column(name = "fk_sex_type", nullable = false)
	private Integer sexTypeId;

	@Column(name = "fk_bank_branch", nullable = false)
	private Integer bankBranchId;

	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "surname", nullable = false)
	private String surname;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

}