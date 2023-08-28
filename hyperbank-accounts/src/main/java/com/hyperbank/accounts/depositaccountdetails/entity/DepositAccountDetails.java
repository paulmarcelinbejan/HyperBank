package com.hyperbank.accounts.depositaccountdetails.entity;

import com.hyperbank.accounts.accountinternal.entity.AccountInternal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "deposit_account_details")
public class DepositAccountDetails {

	@Id
	@Column(name = "id_account", nullable = false)
	private Long id;
	
	@Column(name = "fk_interest_rate_fixed", nullable = false)
	private Long interestRateFixedId;
	
	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_account")
    @MapsId
	private AccountInternal accountInternal;
	
}
