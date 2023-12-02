package com.hyperbank.staff.employee.api.delete.many;

import java.util.List;

import com.paulmarcelinbejan.architecture.sniper.SniperRequestAware;
import com.paulmarcelinbejan.architecture.sniper.stereotype.Sniper;

@Sniper
public interface EmployeeDeleteManySniper extends SniperRequestAware<List<Long>> {
	
}
