package com.hyperbank.banks.bank.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.hyperbank.banks.bank.dto.BankResponse;
import com.hyperbank.banks.bank.dto.BankSaveRequest;
import com.hyperbank.banks.bank.dto.BankUpdateRequest;
import com.hyperbank.banks.bank.entity.Bank;

import io.github.paulmarcelinbejan.toolbox.service.helper.mapping.FullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BankMapper extends FullMapper<Bank, BankSaveRequest, BankUpdateRequest, BankResponse> {

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	Bank fromSaveRequestToEntity(BankSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	List<Bank> fromSaveRequestsToEntities(Collection<BankSaveRequest> saveRequests);
	
	@Override
	@Named("fromUpdateRequestToEntity")
	Bank fromUpdateRequestToEntity(BankUpdateRequest updateRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	List<Bank> fromUpdateRequestsToEntities(Collection<BankUpdateRequest> updateRequests);
	
	@Override
	@Mapping(target = "id", ignore = true)
	void updateEntity(@MappingTarget Bank toUpdate, Bank newValue);

	@Override
	@Named("toResponse")
	BankResponse toResponse(Bank entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	List<BankResponse> toResponses(Collection<Bank> entities);
	
}
