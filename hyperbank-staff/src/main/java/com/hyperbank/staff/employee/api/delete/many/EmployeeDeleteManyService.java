package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paulmarcelinbejan.architecture.sniper.service.ServiceInputAware;

@Service
public interface EmployeeDeleteManyService extends ServiceInputAware<List<Long>> {

}
