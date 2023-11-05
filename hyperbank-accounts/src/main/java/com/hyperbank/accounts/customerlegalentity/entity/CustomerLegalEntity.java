package com.hyperbank.accounts.customerlegalentity.entity;

import com.hyperbank.accounts.customer.entity.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_legal_entity")
public class CustomerLegalEntity {

	@Id
	@Column(name = "id_customer", nullable = false)
	private Long id;

	@Column(name = "fk_headquarters", nullable = false)
	private Long headquartersId;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_customer")
    @MapsId
	private Customer customer;
	
}