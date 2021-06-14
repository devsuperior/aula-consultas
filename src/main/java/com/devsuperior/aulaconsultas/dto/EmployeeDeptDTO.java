package com.devsuperior.aulaconsultas.dto;

import java.io.Serializable;

import com.devsuperior.aulaconsultas.entities.Employee;

public class EmployeeDeptDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String departmentName;
	
	public EmployeeDeptDTO() {
	}

	public EmployeeDeptDTO(Long id, String name, String departmentName) {
		this.id = id;
		this.name = name;
		this.departmentName = departmentName;
	}

	public EmployeeDeptDTO(Employee entity) {
		id = entity.getId();
		name = entity.getName();
		departmentName = entity.getDepartment().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
