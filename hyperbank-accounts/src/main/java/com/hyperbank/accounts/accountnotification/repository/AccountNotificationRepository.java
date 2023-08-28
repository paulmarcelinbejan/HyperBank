package com.hyperbank.accounts.accountnotification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.accounts.accountnotification.entity.AccountNotification;

@Repository
public interface AccountNotificationRepository extends JpaRepository<AccountNotification, Long> {

}
