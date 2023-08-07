package com.hyperbank.accounts.customer.entity;

import com.hyperbank.accounts.customerindividual.entity.CustomerIndividual;
import com.hyperbank.accounts.customerlegalentity.entity.CustomerLegalEntity;
import com.hyperbank.accounts.customertype.entity.CustomerType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "id_customer", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_customer_type")
	private CustomerType customerType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer_individual")
	private CustomerIndividual fkCustomerIndividual;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer_legal_entity")
	private CustomerLegalEntity fkCustomerLegalEntity;

}