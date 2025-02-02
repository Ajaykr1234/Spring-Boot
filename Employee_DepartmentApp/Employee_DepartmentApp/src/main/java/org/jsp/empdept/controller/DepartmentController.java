package org.jsp.empdept.controller;

import java.util.Optional;

import org.jsp.empdept.dto.Department;
import org.jsp.empdept.dto.ResponseStructure;
import org.jsp.empdept.exception.DepartmentNotFoundException;
import org.jsp.empdept.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Department>> saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Department>> updateEmployee(@RequestBody Department department) {
		return departmentService.updateEmployee(department);
	}

}
