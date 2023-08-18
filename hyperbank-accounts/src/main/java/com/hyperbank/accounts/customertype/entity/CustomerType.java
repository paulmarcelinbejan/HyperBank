package com.hyperbank.accounts.customertype.entity;

import com.hyperbank.commons.entity.base.TypeEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_customer_type", nullable = false))
@Table(name = "customer_type")
public class CustomerType extends TypeEntity {

}