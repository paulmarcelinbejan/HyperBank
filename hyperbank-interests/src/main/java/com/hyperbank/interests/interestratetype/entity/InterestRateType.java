package com.hyperbank.interests.interestratetype.entity;

import com.hyperbank.architecture.base.data.entity.TypeEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "interest_rate_type")
@AttributeOverride(name = "id", column = @Column(name = "id_interest_rate_type", nullable = false))
public class InterestRateType extends TypeEntity {

}