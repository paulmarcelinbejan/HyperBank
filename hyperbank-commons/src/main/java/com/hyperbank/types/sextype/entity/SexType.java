package com.hyperbank.types.sextype.entity;

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
@Table(name = "sex_type")
@AttributeOverride(name = "id", column = @Column(name = "id_sex_type", nullable = false))
public class SexType extends TypeEntity {

}