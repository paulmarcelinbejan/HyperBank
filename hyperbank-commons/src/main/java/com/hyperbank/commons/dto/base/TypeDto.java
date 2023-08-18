package com.hyperbank.commons.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public abstract class TypeDto extends CategorizationDto {

	public interface CreateValidation extends CategorizationDto.CreateValidation {
		// validation group marker interface
	}

	public interface UpdateValidation extends CategorizationDto.UpdateValidation {
		// validation group marker interface
	}
	
}
