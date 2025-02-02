package org.jsp.empdept.service;

import java.util.List;
import java.util.Optional;

import org.jsp.empdept.dao.DepartmentDao;
import org.jsp.empdept.dao.EmployeeDao;
import org.jsp.empdept.dto.Department;
import org.jsp.empdept.dto.Employee;
import org.jsp.empdept.dto.ResponseStructure;

import org.jsp.empdept.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee, int dept_id) {

		Optional<Department> recDepartment = departmentDao.FindById(dept_id);

		if (recDepartment.isPresent()) {
			Department department = recDepartment.get();

			employee.setDepartment(department);

			department.getEmployees().add(employee);

			ResponseStructure<Employee> structure = new ResponseStructure<>();
			structure.setData(employeeDao.saveEmployee(employee));
			departmentDao.saveDepartment(department);
			structure.setMessage("Employee save sucessfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return ResponseEntity.status(HttpStatus.CREATED.value()).body(structure);
		}
		throw new EmployeeNotFoundException("Can not save Employee Becouse Department id is Worng!");

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee employee) {
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		Optional<Employee> recEmployee = employeeDao.findById(employee.getId());
		if (recEmployee.isPresent()) {
			Employee dbEmployee = recEmployee.get();
			dbEmployee.setName(employee.getName());
			dbEmployee.setDepartment(employee.getDepartment());
			dbEmployee.setDesignation(employee.getDesignation());
			dbEmployee.setPassword(employee.getPassword());
			dbEmployee.setPhone(employee.getPhone());
			structure.setData(employeeDao.saveEmployee(dbEmployee));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("Employee Updated successfully");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(structure);
		}else {
			throw new EmployeeNotFoundException("Employee not found to update");
		}

	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findByName(String name) {
		List<Employee> recEmployee = employeeDao.findByName(name);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if(recEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found with name"+name);
		}else {
			structure.setData(recEmployee);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Employee found");
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findBySal(double sal) {
		List<Employee> recEmployee = employeeDao.findBySal(sal);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if(recEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found with sal"+sal);
		}else {
			structure.setData(recEmployee);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Employee found");
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
	}
	

	public ResponseEntity<ResponseStructure<List<Employee>>> findEmpBySalRange(double minsal, double maxsal) {
		List<Employee> recEmployee = employeeDao.findEmpBySalRange(minsal, maxsal);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if(recEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found with  sal range");
		}else {
			structure.setData(recEmployee);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Employee found");
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByDepartmentName(String name) {
		List<Employee> recEmployee = employeeDao.findEmployeeByDepartmentName(name);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if(recEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found with as location name "+name);
		}else {
			structure.setData(recEmployee);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Employee found");
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByDepartmentId(int id) {
		List<Employee> recEmployee = employeeDao.findEmployeeByDepartmentId(id);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if(recEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not found with department  id  "+ id);
		}else {
			structure.setData(recEmployee);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Employee found");
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		
	}

}
