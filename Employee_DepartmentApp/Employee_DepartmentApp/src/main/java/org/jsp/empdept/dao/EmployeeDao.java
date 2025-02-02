package org.jsp.empdept.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.empdept.dto.Employee;
import org.jsp.empdept.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Optional<Employee> findById(int emp_id) {
		return employeeRepository.findById(emp_id);

	}

	public List<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	public List<Employee> findBySal(double sal) {
		return employeeRepository.findBySal(sal);
	}

	public List<Employee> findEmpBySalRange(double minsal, double maxsal) {
		return employeeRepository.findEmpBySalRange(minsal, maxsal);
	}

}
