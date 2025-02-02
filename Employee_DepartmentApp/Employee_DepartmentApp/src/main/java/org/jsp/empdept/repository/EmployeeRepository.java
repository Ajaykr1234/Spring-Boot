package org.jsp.empdept.repository;

import org.jsp.empdept.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByName(String name);
	
	List<Employee> findBySal(double sal);
	

	@Query("select emp from Employee emp where emp.sal between ?1 and ?2 ")
	List<Employee> findEmpBySalRange(double minsal,double maxsal);
	
	
}
