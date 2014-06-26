package es.unileon.ulebank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.unileon.ulebank.handler.DNIHandler;
import es.unileon.ulebank.handler.Handler;

@Entity
@Table(name="EMPLOYEES")
public class Employee {

	@Id
    @Column(name = "employee_id")
	private String employeeId;
	
	@Column(name = "name")
	private String name;

	@Column(name = "surnames")
	private String surnames;

	@Column(name = "address")
	private String address;

	@Column(name = "salary")
	private float salary;

	@ManyToOne
	@JoinColumn(name = "office_id", insertable = false, updatable = false)
	private Office office;

	public Employee() {
		
	}
	
	public Employee(Office office, String employeeId, String name, 
			String surnames, float salary, String address) {
		this.office = office;
		Handler idEmployee = new DNIHandler(employeeId);
		this.employeeId = idEmployee.toString();
		this.name = name;
		this.surnames = surnames;
		this.salary = salary;
		this.address = address;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name
				+ ", surnames=" + surnames + ", address=" + address
				+ ", salary=" + salary + ", office=" + office.getOfficeId() + "]";
	}
	
}
