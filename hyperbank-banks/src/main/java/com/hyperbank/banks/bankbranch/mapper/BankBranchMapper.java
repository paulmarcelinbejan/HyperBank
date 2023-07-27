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
import com.hyperbank.banks.bankbranch.dto.BankBranchDto;
import com.hyperbank.banks.bankbranch.entity.BankBranch;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.mapstruct.BaseMapperToEntityAndToDTO;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class BankBranchMapper implements BaseMapperToEntityAndToDTO<BankBranch, BankBranchDto> {

	@Autowired
	private BankService bankService;

	@Override
	@Named("toEntity")
	@Mapping(source = "bankId", target = "bank", qualifiedByName = "getBankById")
	public abstract BankBranch toEntity(BankBranchDto dto);

	@Override
	@IterableMapping(qualifiedByName = "toEntity")
	public abstract Collection<BankBranch> toEntities(Collection<BankBranchDto> dtoList);

	@Override
	@Mapping(source = "bankId", target = "bank", qualifiedByName = "getBankById")
	public abstract void updateEntityFromDto(@MappingTarget BankBranch entity, BankBranchDto dto);

	@Override
	@Named("toDto")
	@Mapping(source = "bank.id", target = "bankId")
	public abstract BankBranchDto toDto(BankBranch entity);

	@Override
	@IterableMapping(qualifiedByName = "toDto")
	public abstract Collection<BankBranchDto> toDtos(Collection<BankBranch> entities);

	@Named("getBankById")
	protected Bank getBankById(Integer id) throws FunctionalException {
		return bankService.findById(id);
	}

}
