package org.jsp.empdept.service;

import java.util.Optional;

import org.jsp.empdept.dao.DepartmentDao;
import org.jsp.empdept.dto.Department;
import org.jsp.empdept.dto.ResponseStructure;
import org.jsp.empdept.exception.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	public ResponseEntity<ResponseStructure<Department>> saveDepartment(Department department) {
		ResponseStructure<Department> structure = new ResponseStructure<>();
		structure.setData(departmentDao.saveDepartment(department));
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Department Added Successfull");
		return ResponseEntity.status(HttpStatus.CREATED).body(structure);
	}

	public ResponseEntity<ResponseStructure<Department>> updateEmployee(Department department) {
		ResponseStructure<Department> structure = new ResponseStructure<>();
		Optional<Department> recDepartment = departmentDao.FindById(department.getId());
		if (recDepartment.isPresent()) {
			Department dbDepartment = recDepartment.get();
			dbDepartment.setLocation(department.getName());
			dbDepartment.setName(department.getName());
			structure.setData(departmentDao.saveDepartment(department));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Department Updated successfully!");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(structure);

		} else {
			throw new DepartmentNotFoundException("Id is not found to update department");
		}

	}

}
