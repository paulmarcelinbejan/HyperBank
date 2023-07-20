package com.hyperbank.commonentities.entity;

import com.hyperbank.commonentities.entity.base.TypeEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "currency")
@AttributeOverride(name = "id", column = @Column(name = "id_currency", nullable = false))
@AttributeOverride(name = "code", column = @Column(name = "code", nullable = false))
@AttributeOverride(name = "description", column = @Column(name = "description", nullable = false))
public class Currency extends TypeEntity {

}