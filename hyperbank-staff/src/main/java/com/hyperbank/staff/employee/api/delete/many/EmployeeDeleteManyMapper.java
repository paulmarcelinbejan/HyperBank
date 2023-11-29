package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import org.mapstruct.Mapper;

import com.hyperbank.staff.employee.api.find.one.EmployeeFindOneMapper;
import com.hyperbank.staff.employee.api.save.one.EmployeeSaveOneMapper;
import com.hyperbank.staff.employee.mapper.EmployeeMapperConfig;
import com.paulmarcelinbejan.architecture.sniper.mapper.input.MapperInput;
import com.paulmarcelinbejan.architecture.sniper.mapper.output.MapperOutput;

@Mapper(config = EmployeeMapperConfig.class,
		uses = { EmployeeFindOneMapper.class, EmployeeSaveOneMapper.class })
public interface EmployeeDeleteManyMapper extends  
	MapperInput<List<Long>, List<Long>>,
	MapperOutput<Void, Void> {
	
	@Override
	default List<Long> toDomain(List<Long> ids) {
		return ids;
	}
	
	@Override
	default Void toResponse(Void nothing) {
		return null;
	}
	
}