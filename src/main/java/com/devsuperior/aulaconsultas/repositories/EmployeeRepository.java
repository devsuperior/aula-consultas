package com.devsuperior.aulaconsultas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.aulaconsultas.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
