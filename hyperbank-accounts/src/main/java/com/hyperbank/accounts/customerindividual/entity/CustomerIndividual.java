package com.hyperbank.accounts.customerindividual.entity;

import java.time.LocalDate;

import com.hyperbank.accounts.customer.entity.Customer;
import com.hyperbank.commons.sextype.entity.SexType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_individual")
public class CustomerIndividual {

	@Id
	@Column(name = "id_customer", nullable = false)
	private Long id;

	@Column(name = "fk_nationality", nullable = false)
	private Integer fkNationality;

	@Column(name = "fk_residence", nullable = false)
	private Long fkResidence;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_sex_type", nullable = false)
	private SexType sexType;

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
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer")
    @MapsId
	private Customer customer;
	
}