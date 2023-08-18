package com.hyperbank.accounts.accounttype.entity;

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
@AttributeOverride(name = "id", column = @Column(name = "id_account_type", nullable = false))
@Table(name = "account_type")
public class AccountType extends TypeEntity {

}