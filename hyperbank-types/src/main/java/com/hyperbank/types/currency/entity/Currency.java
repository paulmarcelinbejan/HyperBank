package com.hyperbank.types.currency.entity;

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
@Table(name = "currency")
@AttributeOverride(name = "id", column = @Column(name = "id_currency", nullable = false))
public class Currency extends TypeEntity {

}