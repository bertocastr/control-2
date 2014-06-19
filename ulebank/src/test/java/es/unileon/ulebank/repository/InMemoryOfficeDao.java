package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;

public class InMemoryOfficeDao implements OfficeDao {

	private List<Office> officeList;
	private List<Employee> employeeList;
	
	public InMemoryOfficeDao(List<Office> officeList, List<Employee> employeeList) {
        this.officeList = officeList;
        this.employeeList = employeeList;
    }
	
	public List<Office> getOfficeList() {
		return officeList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void saveOffice(Office office) {
		officeList.add(office);
		employeeList.addAll(office.getEmployees());
	}

}
