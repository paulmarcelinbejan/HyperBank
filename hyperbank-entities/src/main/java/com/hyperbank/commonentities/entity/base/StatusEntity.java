package com.hyperbank.commonentities.entity.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@MappedSuperclass
public abstract class StatusEntity extends CategorizationEntity {

}
