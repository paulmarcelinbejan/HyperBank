package com.hyperbank.accounts.accountinternaltype.entity;

import com.hyperbank.commonentities.entity.base.TypeEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AttributeOverride(name = "id", column = @Column(name = "id_account_internal_type", nullable = false))
@Table(name = "account_internal_type")
public class AccountInternalType extends TypeEntity {

}
