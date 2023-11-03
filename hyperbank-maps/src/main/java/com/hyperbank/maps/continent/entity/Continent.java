package com.hyperbank.maps.continent.entity;

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
@Table(name = "continent")
public class Continent {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_continent_seq")
	@SequenceGenerator(name = "id_continent_seq", sequenceName = "id_continent_seq", allocationSize = 1)
	@Column(name = "id_continent", nullable = false)
	private Integer id;
	
	@Column(name = "continent_name", nullable = false)
	private String continentName;

}