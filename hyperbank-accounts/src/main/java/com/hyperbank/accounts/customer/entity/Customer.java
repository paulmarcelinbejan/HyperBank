package com.hyperbank.accounts.customer.entity;

import com.hyperbank.accounts.customertype.entity.CustomerType;

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
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_customer_seq")
	@SequenceGenerator(name = "id_customer_seq", sequenceName = "id_customer_seq", allocationSize = 1)
	@Column(name = "id_customer", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer_type", nullable = false)
	private CustomerType customerType;

}