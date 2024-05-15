package org.jsp.empdept.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.empdept.dto.Department;
import org.jsp.empdept.dto.Employee;
import org.jsp.empdept.dto.ResponseStructure;
import org.jsp.empdept.exception.EmployeeNotFoundException;
import org.jsp.empdept.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/{dept_id}")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee,
			@PathVariable(name = "dept_id") int dept_id) {
		return employeeService.saveEmployee(employee, dept_id);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody  Employee employee) {
		return employeeService.updateEmployee(employee);
		
	}
	
	@GetMapping("/findEmployeeByName/{name}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findByName(@PathVariable(name="name") String name) {
		return employeeService.findByName(name);
	}

	@GetMapping("/findEmployeeBySalary/{sal}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findBySal(@PathVariable (name="sal") double sal) {
		return employeeService.findBySal(sal);
	}
	
	@GetMapping("/findEmployeeBySalRange")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmpBySalRange(@RequestParam (name="minsal")  double minsal, @RequestParam (name="maxsal") double maxsal) {
		
		return employeeService.findEmpBySalRange(minsal, maxsal);
	}

}
