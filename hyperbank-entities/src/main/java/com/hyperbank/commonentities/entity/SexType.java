package com.hyperbank.commonentities.entity;

import com.hyperbank.commonentities.entity.base.TypeEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sex_type")
@AttributeOverride(name = "id", column = @Column(name = "id_sex_type", nullable = false))
public class SexType extends TypeEntity {

}