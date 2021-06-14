package com.devsuperior.aulaconsultas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.aulaconsultas.dto.EmployeeDeptDTO;
import com.devsuperior.aulaconsultas.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping(value = "/search1")
	public ResponseEntity<List<EmployeeDeptDTO>> search1() {
		List<EmployeeDeptDTO> list = service.search1("M", "Sales");
		return ResponseEntity.ok(list);
	}
}
