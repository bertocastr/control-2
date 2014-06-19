package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;

public interface OfficeDao {

    public List<Office> getOfficeList();

    public void saveOffice(Office office);
    
    public List<Employee> getEmployeeList();
    
    public List<Account> getAccountList();

}