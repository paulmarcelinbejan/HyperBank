package com.hyperbank.accounts.accountnotification.service;

import com.hyperbank.accounts.accountnotification.entity.AccountNotification;

import io.github.paulmarcelinbejan.toolbox.service.helper.aggregate.CreateReadDeleteServiceHelper;

public interface AccountNotificationService extends CreateReadDeleteServiceHelper<Long, AccountNotification> {

}
