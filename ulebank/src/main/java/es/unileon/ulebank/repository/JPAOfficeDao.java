package es.unileon.ulebank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;

@Repository(value = "officeDao")
public class JPAOfficeDao implements OfficeDao {

    private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Office> getOfficeList() {
        return em.createQuery("select o from Office o order by o.officeId").getResultList();
    }

    @Transactional(readOnly = false)
    public void saveOffice(Office office) {
        em.merge(office);
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Employee> getEmployeeList() {
        return em.createQuery("select e from Employee e order by e.employeeId").getResultList();
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Account> getAccountList() {
        return em.createQuery("select a from Account a order by a.accountNumber").getResultList();
    }

}