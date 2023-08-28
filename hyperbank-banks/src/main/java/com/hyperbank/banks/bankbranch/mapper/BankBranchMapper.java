package com.hyperbank.banks.bankbranch.mapper;

import java.util.Collection;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.hyperbank.banks.bank.entity.Bank;
import com.hyperbank.banks.bank.service.BankService;
import com.hyperbank.banks.bankbranch.dto.BankBranchResponse;
import com.hyperbank.banks.bankbranch.dto.BankBranchSaveRequest;
import com.hyperbank.banks.bankbranch.dto.BankBranchUpdateRequest;
import com.hyperbank.banks.bankbranch.entity.BankBranch;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.mapping.BaseFullMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class BankBranchMapper implements BaseFullMapper<BankBranch, BankBranchSaveRequest, BankBranchUpdateRequest, BankBranchResponse> {

	@Autowired
	private BankService bankService;

	@Override
	@Named("fromSaveRequestToEntity")
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "bankId", target = "bank", qualifiedByName = "getBankById")
	public abstract BankBranch fromSaveRequestToEntity(BankBranchSaveRequest saveRequest);

	@Override
	@IterableMapping(qualifiedByName = "fromSaveRequestToEntity")
	public abstract Collection<BankBranch> fromSaveRequestsToEntities(Collection<BankBranchSaveRequest> saveRequests);
	
	@Override
	@Named("fromUpdateRequestToEntity")
	@Mapping(source = "bankId", target = "bank", qualifiedByName = "getBankById")
	public abstract BankBranch fromUpdateRequestToEntity(BankBranchUpdateRequest updateRequest);
	
	@Override
	@IterableMapping(qualifiedByName = "fromUpdateRequestToEntity")
	public abstract Collection<BankBranch> fromUpdateRequestsToEntities(Collection<BankBranchUpdateRequest> updateRequests);

	@Override
	@Mapping(target = "id", ignore = true)
	public abstract void updateEntity(@MappingTarget BankBranch toUpdate, BankBranch newValue);
	
	@Override
	@Named("toResponse")
	@Mapping(source = "bank.id", target = "bankId")
	public abstract BankBranchResponse toResponse(BankBranch entity);

	@Override
	@IterableMapping(qualifiedByName = "toResponse")
	public abstract Collection<BankBranchResponse> toResponses(Collection<BankBranch> entities);

	@Named("getBankById")
	protected Bank getBankById(Integer id) throws FunctionalException {
		return bankService.findById(id);
	}

}
