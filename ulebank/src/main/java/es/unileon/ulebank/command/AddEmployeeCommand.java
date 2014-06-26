package es.unileon.ulebank.command;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.repository.OfficeDao;
import es.unileon.ulebank.service.OfficeManager;

public class AddEmployeeCommand implements Command{

	private Office office;
	private Employee employee;
	private OfficeManager officeManager;
	
	public AddEmployeeCommand(Office office, Employee employee, OfficeManager officeManager){
		this.office = office;
		this.employee = employee;
		this.officeManager = officeManager;
	}
	public void execute() {
//		this.employee.setOffice(this.office);
//		
//		List<Employee> employees = this.office.getEmployees();
//		
//		employees.add(this.employee);
//		
//		this.office.setEmployees(employees);
//		
//		this.officeDao.saveOffice(this.office);
		this.officeManager.addEmployee(this.employee, this.office);
		
	}

}
