package com.hyperbank.accounts.accountnotification.service;

import com.hyperbank.accounts.accountnotification.entity.AccountNotification;
import com.paulmarcelinbejan.toolbox.service.helper.aggregate.CreateReadDeleteServiceHelper;

public interface AccountNotificationService extends CreateReadDeleteServiceHelper<Long, AccountNotification> {

}
