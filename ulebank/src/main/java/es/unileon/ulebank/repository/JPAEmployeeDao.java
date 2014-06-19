package es.unileon.ulebank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.domain.Employee;

@Repository(value = "employeeDao")
public class JPAEmployeeDao implements EmployeeDao {

    private EntityManager em = null;

    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Employee> getEmployeeList() {
        return em.createQuery("select e from Employee e order by e.employeeId").getResultList();
    }

    @Transactional(readOnly = false)
    public void saveEmployee(Employee employee) {
        em.merge(employee);
    }

}