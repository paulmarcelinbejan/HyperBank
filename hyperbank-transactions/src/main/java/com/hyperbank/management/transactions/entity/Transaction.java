package com.hyperbank.management.transactions.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.hyperbank.commonentities.entity.Currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@Column(name = "id_transaction", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "fk_account_sender", nullable = false)
	private Long fkAccountSender;

	@NotNull
	@Column(name = "fk_account_receiver", nullable = false)
	private Long fkAccountReceiver;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_currency", nullable = false)
	private Currency fkCurrency;

	@NotNull
	@Column(name = "value", nullable = false, precision = 12, scale = 2)
	private BigDecimal value;

	@NotNull
	@Column(name = "transaction_date_time", nullable = false)
	private LocalDateTime transactionDateTime;

}