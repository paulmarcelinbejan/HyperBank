package com.hyperbank.commonentities.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class TypeEntity {

	@Id
	private Integer id;

	@NotBlank
	@Column(name = "code", nullable = false)
	private String code;

	@NotBlank
	@Column(name = "description", nullable = false)
	private String description;

}
