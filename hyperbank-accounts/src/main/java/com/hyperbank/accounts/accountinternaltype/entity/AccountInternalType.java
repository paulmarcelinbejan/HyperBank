package com.hyperbank.accounts.accountinternaltype.entity;

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
@Table(name = "account_internal_type")
@AttributeOverride(name = "id", column = @Column(name = "id_account_internal_type", nullable = false))
public class AccountInternalType extends TypeEntity {

}
