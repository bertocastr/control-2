package es.unileon.ulebank.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.repository.EmployeeDao;
import es.unileon.ulebank.repository.OfficeDao;

public interface OfficeManager extends Serializable {

	public void setOfficeDao(OfficeDao officeDao);

	public List<Office> getOffices();
	
	public void setEmployeeDao(EmployeeDao employeeDao);
	
	public List<Employee> getEmployees();

	public void addEmployee(Employee employee, Office office);

}