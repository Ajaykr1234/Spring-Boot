package org.jsp.empdept.dao;

import java.util.Optional;

import org.jsp.empdept.dto.Department;
import org.jsp.empdept.dto.Employee;
import org.jsp.empdept.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public Optional<Department> FindById(int dept_id) {
		return departmentRepository.findById(dept_id);

	}
	
	

}
