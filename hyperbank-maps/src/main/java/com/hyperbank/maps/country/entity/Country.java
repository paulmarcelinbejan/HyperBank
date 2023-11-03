package com.hyperbank.maps.country.entity;

import com.hyperbank.maps.continent.entity.Continent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_country_seq")
	@SequenceGenerator(name = "id_country_seq", sequenceName = "id_country_seq", allocationSize = 1)
	@Column(name = "id_country", nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_continent", nullable = false)
	private Continent continent;
	
	@Column(name = "country_name", nullable = false)
	private String countryName;

}