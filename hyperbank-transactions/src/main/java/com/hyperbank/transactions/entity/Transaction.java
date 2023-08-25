package com.hyperbank.transactions.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@Column(name = "id_transaction", nullable = false)
	private Long id;

	@Column(name = "fk_account_sender", nullable = false)
	private Long fkAccountSender;

	@Column(name = "fk_account_receiver", nullable = false)
	private Long fkAccountReceiver;

	@Column(name = "fk_currency", nullable = false)
	private Integer currencyId;

	@Column(name = "value", nullable = false, precision = 12, scale = 2)
	private BigDecimal value;

	@Column(name = "transaction_date_time", nullable = false)
	private LocalDateTime transactionDateTime;

}