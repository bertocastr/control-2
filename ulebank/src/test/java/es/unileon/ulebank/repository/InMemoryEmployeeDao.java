package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.Employee;

public class InMemoryEmployeeDao implements EmployeeDao {

	private List<Employee> employeeList;
	
	 public InMemoryEmployeeDao(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void saveEmployee(Employee employee) {
		
	}

}
