package es.unileon.ulebank.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OfficeTests {

    private Office office;

    @Before
    public void setUp() throws Exception {
        office = new Office();
    }
    
    @Test
    public void testSetAndGetOfficeId() {
        String testOfficeId = "0001";
        assertNull(office.getOfficeId());
        office.setOfficeId(testOfficeId);
        assertEquals(testOfficeId, office.getOfficeId());
    }
    
    @Test
    public void testSetAndGetBankId() {
        String testBankId = "2401";
        assertNull(office.getBankId());
        office.setBankId(testBankId);
        assertEquals(testBankId, office.getBankId());
    }
    
    @Test
    public void testSetAndGetAddress() {
        String testAddress = "street";
        assertNull(office.getAddress());
        office.setAddress(testAddress);
        assertEquals(testAddress, office.getAddress());
    }
    
    @Test
    public void testSetAndGetZip() {
        String testZip = "24080";
        assertNull(office.getZip());
        office.setZip(testZip);
        assertEquals(testZip, office.getZip());
    }
    
    @Test
    public void testSetAndGetPhone() {
        String testPhone = "987987987";
        assertNull(office.getPhone());
        office.setPhone(testPhone);
        assertEquals(testPhone, office.getPhone());
    }
    
    @Test
    public void testSetAndGetLocalCost() {
        float testLocalCost = 1000000;
        assertEquals(office.getLocalCost(), 0.0, 0);
        office.setLocalCost(testLocalCost);
        assertEquals(testLocalCost, office.getLocalCost(), 0);
    }

    @Test
    public void testSetAndGetUtilitiesCost() {
        float testUtilitiesCost = 800000;
        assertEquals(office.getUtilitiesCost(), 0.0, 0);
        office.setUtilitiesCost(testUtilitiesCost);
        assertEquals(testUtilitiesCost, office.getUtilitiesCost(), 0);
    }
    
    @Test
    public void testSetAndGetEmployeeCost() {
        float testEmployeeCost = 1000000;
        assertEquals(office.getEmployeeCost(), 0.0, 0);
        office.setEmployeeCost(testEmployeeCost);
        assertEquals(testEmployeeCost, office.getEmployeeCost(), 0);
    }
    
    @Test
    public void testSetAndGetTotalExpenses() {
        float testTotalExpenses = 1900000;
        assertEquals(office.getTotalExpenses(), 0.0, 0);
        office.setTotalExpenses(testTotalExpenses);
        assertEquals(testTotalExpenses, office.getTotalExpenses(), 0);
    }
    
    @Test
    public void testSetAndGetTotalIncome() {
        float testTotalIncome = 100000000;
        assertEquals(office.getTotalIncome(), 0.0, 0);
        office.setTotalIncome(testTotalIncome);
        assertEquals(testTotalIncome, office.getTotalIncome(), 0);
    }
    
   	@Test
    public void testSetAndGetBalance() {
        float testBalance = 98100000;
        assertEquals(office.getBalance(), 0.0, 0);
        office.setBalance(testBalance);
        assertEquals(testBalance, office.getBalance(), 0);
    }
   	
   	@Test
    public void testSetAndGetAccountNumber() {
        String testAccountNumber = "1234567890";
        assertNull(office.getAccountNumber());
        office.setAccountNumber(testAccountNumber);
        assertEquals(testAccountNumber, office.getAccountNumber());
    }
   	
   	@Test
    public void testSetAndGetNextAccountNumber() {
        Float testNextAccountNumber = 0.0f;
        assertEquals(office.getNextAccountNumber(), 0.0f, 0);
        office.setNextAccountNumber(testNextAccountNumber);
        assertEquals(testNextAccountNumber, office.getNextAccountNumber(), 0);
    }
 
}
