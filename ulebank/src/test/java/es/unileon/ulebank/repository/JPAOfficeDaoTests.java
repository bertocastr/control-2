package es.unileon.ulebank.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;

public class JPAOfficeDaoTests {

	private ApplicationContext context;
    private OfficeDao officeDao;
    private EmployeeDao employeeDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        officeDao = (OfficeDao) context.getBean("officeDao");
        employeeDao = (EmployeeDao) context.getBean("employeeDao");
    }

    @Test
    public void testGetOfficeList() {
        List<Office> offices = officeDao.getOfficeList();
        assertEquals(offices.size(), 1, 0);	   
    }

    @Test
    public void testSaveOffice() {
    	
        List<Office> offices = officeDao.getOfficeList();
    	
        Office o = offices.get(0);
        String address = o.getAddress();
        o.setAddress("C/ Ancha, 145");
        String zip = o.getZip();
        o.setZip("24000");
        String phone = o.getPhone();
        o.setPhone("111222333");
        Float localCost = o.getLocalCost();
        o.setLocalCost(1234567.89f);
        Float utilitiesCost = o.getUtilitiesCost();
        o.setUtilitiesCost(1234567.89f);
        Float employeeCost = o.getEmployeeCost();
        o.setEmployeeCost(1234567.89f);
        Float totalExpenses = o.getTotalExpenses();
        o.setTotalExpenses(1234567.89f);
        Float totalIncome = o.getTotalIncome();
        o.setTotalIncome(1234567.89f);
        Float balance = o.getBalance();
        o.setBalance(1234567.89f);
        String accountNumber = o.getAccountNumber();
        o.setAccountNumber("1111111111");
        Float nextAccountNumber = o.getNextAccountNumber();
        o.setNextAccountNumber(1.0f);
        
        officeDao.saveOffice(o);

        List<Office> updatedOffices = officeDao.getOfficeList();
        Office e2 = updatedOffices.get(0);
        assertEquals(e2.getAddress(), "C/ Ancha, 145");
        assertEquals(e2.getZip(), "24000");
        assertEquals(e2.getPhone(), "111222333");
        assertEquals(e2.getLocalCost(), 1234567.89f, 0);
        assertEquals(e2.getUtilitiesCost(), 1234567.89f, 0);
        assertEquals(e2.getEmployeeCost(), 1234567.89f, 0);
        assertEquals(e2.getTotalExpenses(), 1234567.89f, 0);
        assertEquals(e2.getTotalIncome(), 1234567.89f, 0);
        assertEquals(e2.getBalance(), 1234567.89f, 0);
        assertEquals(e2.getAccountNumber(), "1111111111");
        assertEquals(e2.getNextAccountNumber(),1.0f, 0);

        e2.setAddress(address);
        e2.setZip(zip);
        e2.setPhone(phone);
        e2.setLocalCost(localCost);
        e2.setUtilitiesCost(utilitiesCost);
        e2.setEmployeeCost(employeeCost);
        e2.setTotalExpenses(totalExpenses);
        e2.setTotalIncome(totalIncome);
        e2.setBalance(balance);
        e2.setAccountNumber(accountNumber);
        e2.setNextAccountNumber(nextAccountNumber);
        officeDao.saveOffice(e2);
        
    }
    
    @Test
    public void testSaveEmployee() {

    	Office o = new Office();
    	o.setOfficeId("0001");
        o.setBankId("2401");
        o.setAddress("addressOffice");
        o.setZip("24080");
        o.setPhone("987987987");
        o.setLocalCost(1234567.89f);
        o.setUtilitiesCost(1234567.89f);
        o.setEmployeeCost(1234567.89f);
        o.setTotalExpenses(1234567.89f);
        o.setTotalIncome(1234567.89f);
        o.setBalance(1234567.89f);
        o.setAccountNumber("1111111111");
        o.setNextAccountNumber(1.0f);
    	
    	Employee e = new Employee();
    	e.setEmployeeId("71519821X");
        e.setName("nameEmployee3");
        e.setSurnames("surnameEmployee3");
        e.setAddress("streetEmployee3");
        e.setSalary(3000.30f);
        e.setOffice(o);
        
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(e);
        o.setEmployees(employees);
        
        officeDao.saveOffice(o);
        
        List<Employee> employeesUpdated = employeeDao.getEmployeeList();
        assertEquals(employeesUpdated.size(), 3);
        
    }
    
}

