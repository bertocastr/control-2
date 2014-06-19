package es.unileon.ulebank.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTests {

    private Employee employee;

    @Before
    public void setUp() throws Exception {
        employee = new Employee();
    }
    
    @Test
    public void testSetAndGetId() {
        String testIdBien = "71461175Z";
        assertNull(employee.getEmployeeId());
        employee.setEmployeeId(testIdBien);
        assertEquals(testIdBien, employee.getEmployeeId());
    }
    
    @Test
    public void testSetAndGetName() {
        String testName = "nombre";
        assertNull(employee.getName());
        employee.setName(testName);
        assertEquals(testName, employee.getName());
    }
    
    @Test
    public void testSetAndGetSurname() {
        String testSurname = "surnames";
        assertNull(employee.getSurnames());
        employee.setSurnames(testSurname);
        assertEquals(testSurname, employee.getSurnames());
    }
    
    @Test
    public void testSetAndGetAddress() {
        String testAddress = "address";
        assertNull(employee.getAddress());
        employee.setAddress(testAddress);
        assertEquals(testAddress, employee.getAddress());
    }
    
    @Test
    public void testSetAndGetSalary() {
        Float testSalary = 500.13f;
        assertEquals(employee.getSalary(), 0.0, 0);
        employee.setSalary(testSalary);
        assertEquals(testSalary, employee.getSalary(), 0);
    }
    
}
