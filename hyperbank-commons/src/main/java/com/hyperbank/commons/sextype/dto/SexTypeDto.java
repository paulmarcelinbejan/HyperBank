package com.hyperbank.commons.sextype.dto;

import com.hyperbank.commons.dto.base.TypeDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class SexTypeDto extends TypeDto {

	public interface CreateValidation extends TypeDto.CreateValidation {
		// validation group marker interface
	}

	public interface UpdateValidation extends TypeDto.UpdateValidation {
		// validation group marker interface
	}
	
}
