package com.hyperbank.accounts.accountnotification.service;

import com.hyperbank.accounts.accountnotification.entity.AccountNotification;
import com.paulmarcelinbejan.toolbox.web.service.aggregate.CreateReadDeleteService;

public interface AccountNotificationService extends CreateReadDeleteService<Long, AccountNotification> {

}
