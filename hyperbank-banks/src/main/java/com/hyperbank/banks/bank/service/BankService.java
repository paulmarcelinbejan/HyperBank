package com.hyperbank.banks.bank.service;

import com.hyperbank.banks.bank.dto.BankDto;
import com.hyperbank.banks.bank.entity.Bank;
import com.paulmarcelinbejan.toolbox.web.service.CrudService;

public interface BankService extends CrudService<Integer, Bank, BankDto> {

}
