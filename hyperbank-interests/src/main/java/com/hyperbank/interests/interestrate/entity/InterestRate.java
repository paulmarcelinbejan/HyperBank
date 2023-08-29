package com.hyperbank.interests.interestrate.entity;

import com.hyperbank.interests.interestratetype.entity.InterestRateType;

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
@Table(name = "interest_rate")
public class InterestRate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_interest_rate_seq")
	@SequenceGenerator(name = "id_interest_rate_seq", sequenceName = "id_interest_rate_seq", allocationSize = 1)
	@Column(name = "id_interest_rate", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_interest_rate_type")
	private InterestRateType interestRateType;

}