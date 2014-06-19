package es.unileon.ulebank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.handler.DNIHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.repository.EmployeeDao;
import es.unileon.ulebank.repository.InMemoryEmployeeDao;
import es.unileon.ulebank.repository.InMemoryOfficeDao;
import es.unileon.ulebank.repository.OfficeDao;

public class SimpleOfficeManagerTests {

  	private SimpleOfficeManager officeManager;
    
    private List<Office> offices;
    private List<Employee> employees;
	
	private static int OFFICES_COUNT = 1;
	private static int EMPLOYEES_COUNT = 2;
    
    private static String ID = "0001";
    private static String ID_BANK = "2401";
	private static String ADDRESS = "address1";
	private static String ZIP = "24080";
	private static String PHONE = "987987987";
	private static float LOCAL_COST = 10000;
	private static float UTILITIES_COST = 10000;
	private static float EMPLOYEE_COST = 10000;
	private static float TOTAL_EXPENSES = 10000;
	private static float TOTAL_INCOME = 10000;
	private static float BALANCE = 10000;
	private static String ACCOUNT_NUMBER = "123456789";
	private static float NEXT_ACCOUNT_NUMBER = 0;

    private static String EMPLOYEE1_NAME = "nameEmployee1";
    private static String EMPLOYEE1_SURNAME = "surnamesEmployee1";
    private static String EMPLOYEE1_ADDRESS = "addressEmployee1";
    private static float EMPLOYEE1_SALARY = 1000.10f;
    private static String EMPLOYEE1_OFFICE = "0001";
    private static String EMPLOYEE1_ID = "71461175Z";
    
    private static String EMPLOYEE2_NAME = "nameEmployee2";
    private static String EMPLOYEE2_SURNAME = "surnamesEmployee2" ;
    private static String EMPLOYEE2_ADDRESS = "addressEmployee2";
    private static float EMPLOYEE2_SALARY = 2000.20f;
    private static String EMPLOYEE2_OFFICE = "0001";
    private static String EMPLOYEE2_ID = "70876871W";
    
    Employee EMPLOYEE3;
    
    private Office office;
    
    @Before
    public void setUp() throws Exception {
 		
        officeManager = new SimpleOfficeManager();
        offices = new ArrayList<Office>();
        employees = new ArrayList<Employee>();

        office = new Office(ID,	ID_BANK, ADDRESS, ZIP, PHONE, LOCAL_COST, 
        		UTILITIES_COST, EMPLOYEE_COST, TOTAL_EXPENSES, TOTAL_INCOME, 
        		BALANCE, ACCOUNT_NUMBER, NEXT_ACCOUNT_NUMBER);
        
        offices.add(office);

        Employee employee1 = new Employee(office,"71461175Z","nameEmployee1","surnamesEmployee1",1000.10f,"addressEmployee1");
        employees.add(employee1);
        Employee employee2 = new Employee(office,"70876871W","nameEmployee2","surnamesEmployee2",2000.20f,"addressEmployee2");
        employees.add(employee2);
        
        EMPLOYEE3 = new Employee(office,"71463171D","nameEmployee3","surnameEmployee3",3000.30f,"addressEmployee3");
             
        OfficeDao officeDao = new InMemoryOfficeDao(offices,employees);
        EmployeeDao employeeDao = new InMemoryEmployeeDao(employees);
        officeManager.setOfficeDao(officeDao);
        officeManager.setEmployeeDao(employeeDao);
              
    }

    @Test
    public void testGetOfficesWithEmptyListOfOffices() {
    	officeManager = new SimpleOfficeManager();
    	officeManager.setOfficeDao(new InMemoryOfficeDao(new ArrayList<Office>(), null));
    	assertEquals(officeManager.getOffices().size(), 0);
    }

	@Test
    public void testGetOffices() {
		List<Office> offices = officeManager.getOffices();
        assertNotNull(offices);        
        assertEquals(OFFICES_COUNT, officeManager.getOffices().size());
    
        Office office = offices.get(0);
        assertEquals(ID, office.getOfficeId());
        assertEquals(ID_BANK, office.getBankId());
        assertEquals(ADDRESS, office.getAddress());
        assertEquals(ZIP, office.getZip());
        assertEquals(PHONE, office.getPhone()); 
        assertEquals(LOCAL_COST, office.getLocalCost(), 0); 
        assertEquals(UTILITIES_COST, office.getUtilitiesCost(), 0);
        assertEquals(EMPLOYEE_COST, office.getEmployeeCost(), 0);
        assertEquals(TOTAL_EXPENSES, office.getTotalExpenses(), 0);
        assertEquals(TOTAL_INCOME, office.getTotalIncome(), 0);
        assertEquals(BALANCE, office.getBalance(), 0);
        assertEquals(ACCOUNT_NUMBER, office.getAccountNumber());
        assertEquals(NEXT_ACCOUNT_NUMBER, office.getNextAccountNumber(), 0);
	}
	
	@Test
    public void testAddEmployeeWithNullListOfEmployees() {
        try {
            officeManager = new SimpleOfficeManager();
            officeManager.setOfficeDao(new InMemoryOfficeDao(null, null));
            officeManager.addEmployee(EMPLOYEE3, office);
        }
        catch(NullPointerException ex) {
            fail("Employees list is null.");
        }
    }

    @Test
    public void testGetEmployeessWithEmptyListOfEmployees() {
    	officeManager = new SimpleOfficeManager();
    	officeManager.setOfficeDao(new InMemoryOfficeDao(null, new ArrayList<Employee>()));
    	assertEquals(officeManager.getEmployees().size(), 0);
    }

	
	@Test
    public void testGetEmployees() {
		List<Employee> employees = officeManager.getEmployees();
        assertNotNull(employees);        
        assertEquals(EMPLOYEES_COUNT, officeManager.getEmployees().size());
     
        Employee employee = employees.get(0);
        assertEquals(EMPLOYEE1_NAME, employee.getName());
        assertEquals(EMPLOYEE1_SURNAME, employee.getSurnames());
        assertEquals(EMPLOYEE1_ADDRESS, employee.getAddress());
        assertEquals(EMPLOYEE1_SALARY, employee.getSalary(), 0);
        assertEquals(EMPLOYEE1_OFFICE, employee.getOffice().getOfficeId());
        assertEquals(EMPLOYEE1_ID, employee.getEmployeeId());
        
        employee = employees.get(1);  
        assertEquals(EMPLOYEE2_NAME, employee.getName());
        assertEquals(EMPLOYEE2_SURNAME, employee.getSurnames());
        assertEquals(EMPLOYEE2_ADDRESS, employee.getAddress());
        assertEquals(EMPLOYEE2_SALARY, employee.getSalary(), 0);
        assertEquals(EMPLOYEE2_OFFICE, employee.getOffice().getOfficeId());
        assertEquals(EMPLOYEE2_ID, employee.getEmployeeId());
	}

    @Test
    public void testAddEmployee() {
    	assertNotNull(officeManager.getEmployees());
    	assertEquals(officeManager.getEmployees().size(), 2);
    	
    	officeManager.addEmployee(EMPLOYEE3, office);
    	
    	List<Employee> employees = officeManager.getEmployees();
		assertEquals(employees.size(), 3);
		
		Employee employee = employees.get(0);
		Handler id = new DNIHandler("71461175Z");
		assertEquals(id.toString().compareTo(employee.getEmployeeId()), 0);
		
		employee = employees.get(1);
		id = new DNIHandler("70876871W");
		assertEquals(id.toString().compareTo(employee.getEmployeeId()), 0);
		
		employee = employees.get(2);
		id = new DNIHandler("71463171D");
		assertEquals(id.toString().compareTo(employee.getEmployeeId()), 0);
    }
    
}
