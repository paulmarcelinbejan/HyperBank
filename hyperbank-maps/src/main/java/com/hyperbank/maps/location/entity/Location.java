package com.hyperbank.maps.location.entity;

import com.hyperbank.maps.city.entity.City;

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
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_location_seq")
	@SequenceGenerator(name = "id_location_seq", sequenceName = "id_location_seq", allocationSize = 1)
	@Column(name = "id_location", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_city", nullable = false)
	private City city;
	
	@Column(name = "street_name", nullable = false)
	private String streetName;
	
	@Column(name = "street_number", nullable = false)
	private Integer streetNumber;
	
	@Column(name = "postal_code", nullable = false)
	private String postalCode;

}