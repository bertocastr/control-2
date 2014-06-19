package es.unileon.ulebank.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.OfficeHandler;

@Entity
@Table(name="OFFICES")
public class Office {

	@Id
    @Column(name = "office_id")
    private String officeId;
	
	@Column(name = "bank_id")
    private String bankId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "zip")
	private String zip;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "local_cost")
	private float localCost;
	
	@Column(name = "utilities_cost")
	private float utilitiesCost;
	
	@Column(name = "employee_cost")
	private float employeeCost;
	
	@Column(name = "total_expenses")
	private float totalExpenses;
	
	@Column(name = "total_income")
	private float totalIncome;
	
	@Column(name = "balance")
	private float balance;
	
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "next_account_number")
	private float nextAccountNumber;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "office_id", nullable = false)
	List<Employee> employees;
	
	/*@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "office_id", nullable = false)
	List<Account> accounts;*/

	public Office() {
		
	}
	
	public Office(String officeId, String bankId, String address, String zip,
			String phone, float localCost, float utilitiesCost, float employeeCost, 
			float totalExpenses, float totalIncome, float balance, String accountNumber,
			float nextAccountNumber) {
		Handler idOffice = new OfficeHandler(officeId);
		this.officeId = idOffice.toString();
        this.bankId = bankId;
        this.address = address;
        this.zip = zip;
        this.phone = phone;
        this.localCost = localCost;
        this.utilitiesCost = utilitiesCost;
        this.employeeCost = employeeCost;
        this.totalExpenses = totalExpenses;
        this.totalIncome = totalIncome;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.nextAccountNumber = nextAccountNumber;
        this.employees = new ArrayList<Employee>();
    }

    public Office(String officeId, String bankId, String address, String zip,
			String phone, float localCost, float utilitiesCost, float employeeCost, 
			float totalExpenses, float totalIncome, float balance, String accountNumber,
			float nextAccountNumber, List<Employee> employees) {
    	Handler idOffice = new OfficeHandler(officeId);
		this.officeId = idOffice.toString();
        this.bankId = bankId;
        this.address = address;
        this.zip = zip;
        this.phone = phone;
        this.localCost = localCost;
        this.utilitiesCost = utilitiesCost;
        this.employeeCost = employeeCost;
        this.totalExpenses = totalExpenses;
        this.totalIncome = totalIncome;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.nextAccountNumber = nextAccountNumber;
        this.employees = employees;
    }

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getLocalCost() {
		return localCost;
	}

	public void setLocalCost(float localCost) {
		this.localCost = localCost;
	}

	public float getUtilitiesCost() {
		return utilitiesCost;
	}

	public void setUtilitiesCost(float utilitiesCost) {
		this.utilitiesCost = utilitiesCost;
	}

	public float getEmployeeCost() {
		return employeeCost;
	}

	public void setEmployeeCost(float employeeCost) {
		this.employeeCost = employeeCost;
	}

	public float getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(float totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	public float getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(float totalIncome) {
		this.totalIncome = totalIncome;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getNextAccountNumber() {
		return nextAccountNumber;
	}

	public void setNextAccountNumber(float nextAccountNumber) {
		this.nextAccountNumber = nextAccountNumber;
	}
	
	@Transient
    public String getNextAccountNumberComplete() {
        String number = String.format("%010d", this.nextAccountNumber++);
        return this.bankId + this.officeId + number;
    }

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/*public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}*/

	@Override
	public String toString() {
		return "Office [officeId=" + officeId + ", bankId=" + bankId
				+ ", address=" + address + ", zip=" + zip + ", phone=" + phone
				+ ", localCost=" + localCost + ", utilitiesCost="
				+ utilitiesCost + ", employeeCost=" + employeeCost
				+ ", totalExpenses=" + totalExpenses + ", totalIncome="
				+ totalIncome + ", balance=" + balance + ", accountNumber="
				+ accountNumber + ", nextAccountNumber=" + nextAccountNumber
				+ "]";
	}
   
}
