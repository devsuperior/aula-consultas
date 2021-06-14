package com.devsuperior.aulaconsultas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.aulaconsultas.dto.EmployeeDeptDTO;
import com.devsuperior.aulaconsultas.entities.Employee;
import com.devsuperior.aulaconsultas.projections.EmployeeDeptProjection;
import com.devsuperior.aulaconsultas.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Transactional(readOnly = true)
	public List<EmployeeDeptDTO> search1(String startName, String departmentName) {
		List<Employee> result = repository.findByNameStartingWithAndDepartmentNameNot(startName, departmentName);
		return result.stream().map(x -> new EmployeeDeptDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<EmployeeDeptDTO> search2(String startName, String departmentName) {
		List<Employee> result = repository.search2(startName, departmentName);
		return result.stream().map(x -> new EmployeeDeptDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<EmployeeDeptDTO> search3(String startName, String departmentName) {
		return repository.search3(startName, departmentName);
	}

	@Transactional(readOnly = true)
	public List<EmployeeDeptDTO> search4(String startName, String departmentName) {
		List<EmployeeDeptProjection> result = repository.search4(startName, departmentName);
		return result.stream().map(x -> new EmployeeDeptDTO(x)).collect(Collectors.toList());
	}
}
