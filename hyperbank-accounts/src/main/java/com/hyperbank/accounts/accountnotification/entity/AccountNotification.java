package com.hyperbank.accounts.accountnotification.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_notification")
public class AccountNotification {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_account_notification_seq")
	@SequenceGenerator(name = "id_account_notification_seq", sequenceName = "id_account_notification_seq", allocationSize = 1)
	@Column(name = "id_account_notification", nullable = false)
	private Long id;

	@Column(name = "fk_account", nullable = false)
	private Long accountId;

	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "message", nullable = false)
	private String message;
	
	@Column(name = "date_time", nullable = false)
	private Instant dateTime;

}
