package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.Employee;

public interface EmployeeDao {

    public List<Employee> getEmployeeList();

    public void saveEmployee(Employee employee);
	
}

