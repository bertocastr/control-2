package es.unileon.ulebank.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.domain.Employee;

public class JPAEmployeeDaoTests {

	private ApplicationContext context;
    private EmployeeDao employeeDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        employeeDao = (EmployeeDao) context.getBean("employeeDao");
    }

    @Test
    public void testGetEmployeeList() {
        List<Employee> employees = employeeDao.getEmployeeList();
        assertEquals(employees.size(), 2, 0);	   
    }

    @Test
    public void testSaveEmployee() {
    	
        List<Employee> employees = employeeDao.getEmployeeList();

        Employee e = employees.get(0);
        String name = e.getName();
        e.setName("Juana");
        String surname = e.getSurname();
        e.setSurname("Alvarez");
        String address = e.getAddress();
        e.setAddress("Avda. Raiz, 503, 3º B");
        Float salary = e.getSalary();
        e.setSalary(1000.50f);
        employeeDao.saveEmployee(e);

        List<Employee> updatedEmployees = employeeDao.getEmployeeList();
        Employee e2 = updatedEmployees.get(0);
        assertEquals(e2.getName(),"Juana");
        assertEquals(e2.getSurname(),"Alvarez");
        assertEquals(e2.getAddress(),"Avda. Raiz, 503, 3º B");
        assertEquals(e2.getSalary(), 1000.50, 0);

        e2.setName(name);
        e2.setSurname(surname);
        e2.setAddress(address);
        e2.setSalary(salary);
        employeeDao.saveEmployee(e2);
        
    }
}

