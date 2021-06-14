package com.devsuperior.aulaconsultas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.aulaconsultas.dto.EmployeeDeptDTO;
import com.devsuperior.aulaconsultas.entities.Employee;
import com.devsuperior.aulaconsultas.projections.EmployeeDeptProjection;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByNameStartingWithAndDepartmentNameNot(String startName, String departmentName);

	@Query("SELECT obj "
			+ "FROM Employee obj JOIN FETCH obj.department "
			+ "WHERE obj.name LIKE CONCAT(:startName,'%') "
			+ "AND obj.department.name <> :departmentName")
	List<Employee> search2(String startName, String departmentName);

	@Query("SELECT new com.devsuperior.aulaconsultas.dto.EmployeeDeptDTO(obj.id, obj.name, obj.department.name) "
			+ "FROM Employee obj "
			+ "WHERE obj.name LIKE CONCAT(:startName,'%') "
			+ "AND obj.department.name <> :departmentName")
	List<EmployeeDeptDTO> search3(String startName, String departmentName);
	
	@Query(nativeQuery = true, value = "SELECT tb_employee.id, tb_employee.name, tb_department.name AS departmentName "
			+ "FROM tb_employee "
			+ "INNER JOIN tb_department ON tb_department.id = tb_employee.department_id "
			+ "WHERE tb_employee.name LIKE CONCAT(:startName,'%') "
			+ "AND tb_department.name <> :departmentName")
	List<EmployeeDeptProjection> search4(String startName, String departmentName);	
}
