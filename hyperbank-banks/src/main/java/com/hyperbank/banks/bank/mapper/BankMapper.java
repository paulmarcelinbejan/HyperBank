package com.hyperbank.banks.bank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.hyperbank.banks.bank.dto.BankDto;
import com.hyperbank.banks.bank.entity.Bank;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BankMapper extends BaseMapperToEntityAndToDTO<Bank, BankDto> {

	@Override
	@Mapping(target = "id", ignore = true)
	void updateEntity(@MappingTarget Bank toUpdate, Bank newValue);

}
