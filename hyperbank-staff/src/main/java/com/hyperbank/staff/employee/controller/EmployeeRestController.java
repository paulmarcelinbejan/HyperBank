package com.hyperbank.staff.employee.controller;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hyperbank.staff.employee.dto.EmployeeResponse;
import com.hyperbank.staff.employee.dto.EmployeeSaveRequest;
import com.hyperbank.staff.employee.dto.EmployeeUpdateRequest;
import com.hyperbank.staff.employee.mapper.EmployeeMapper;
import com.hyperbank.staff.employee.service.EmployeeService;
import com.hyperbank.staff.employee.sniper.SniperSaveEmployee;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeRestController {

	private final SniperSaveEmployee sniperSaveEmployee;
	
	private final EmployeeService employeeService;
	
	private final EmployeeMapper employeeMapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EmployeeResponse findById(@PathVariable Long id) throws FunctionalException {
		return employeeMapper.toResponse(employeeService.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<EmployeeResponse> findAll() {
		return employeeMapper.toResponses(employeeService.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long save(@Valid @RequestBody final EmployeeSaveRequest saveRequest) throws FunctionalException, TechnicalException {
		return sniperSaveEmployee.fire(saveRequest).getId();
//		return employeeService.save(employeeMapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> save(@RequestBody final Collection<EmployeeSaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return employeeService.save(employeeMapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Long update(@Valid @RequestBody final EmployeeUpdateRequest updateRequest) throws FunctionalException {
		return employeeService.update(employeeMapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Long> update(@RequestBody final Collection<EmployeeUpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return employeeService.update(employeeMapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable Long id) throws FunctionalException {
		employeeService.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<Long> ids) throws FunctionalException {
		employeeService.deleteMany(ids);
		return new OkResponse();
	}

}
