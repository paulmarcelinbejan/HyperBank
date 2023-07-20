package com.hyperbank.maps.city.entity;

import com.hyperbank.maps.country.entity.Country;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_city_seq")
	@SequenceGenerator(name = "id_city_seq", sequenceName = "id_city_seq", allocationSize = 1)
	@Column(name = "id_city", nullable = false)
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_country", nullable = false)
	private Country country;

	@NotNull
	@Column(name = "city_name", nullable = false)
	private String cityName;

}