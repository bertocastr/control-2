package es.unileon.ulebank.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.unileon.ulebank.command.AddEmployeeCommand;
import es.unileon.ulebank.command.Command;
import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.handler.OfficeHandler;
import es.unileon.ulebank.service.AddEmployee;
import es.unileon.ulebank.service.Searcher;
import es.unileon.ulebank.service.OfficeManager;

@Controller
@RequestMapping(value="/addemployee.htm")
public class AddEmployeeFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private OfficeManager officeManager;

    Command addEmployeeCommand;
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid AddEmployee addEmployee, BindingResult result)
    {
        if (result.hasErrors()) {
            return "addemployee";
        }
		
        String name = addEmployee.getName();
        String surnames = addEmployee.getSurnames();
        String address = addEmployee.getAddress();
        float salary = addEmployee.getSalary();
        String employeeId = addEmployee.getEmployeeId();
        Office o = officeManager.findOffice(new OfficeHandler("0001"));
        Employee employee = new Employee(o, employeeId, name, surnames, salary, address);
//		Command addEmployeeCommand = new AddEmployeeCommand(o, employee, getProductManager());
        initializeCommand(o, employee, getProductManager());
		addEmployeeCommand.execute();
//        officeManager.addEmployee(employee, o);
        logger.info("Adding employee " + employeeId + ".");
        
        return "redirect:/startpage.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected AddEmployee formBackingObject(HttpServletRequest request) throws ServletException {
    	AddEmployee addEmployee = new AddEmployee();
    	addEmployee.setName("");
    	addEmployee.setSurnames("");
    	addEmployee.setAddress("");
    	addEmployee.setSalary(2053.62f);
    	addEmployee.setEmployeeId("");
    	addEmployee.setOfficeId("");
        return addEmployee;
    }

    public void setProductManager(OfficeManager officeManager) {
        this.officeManager = officeManager;
    }

    public OfficeManager getProductManager() {
        return officeManager;
    }

    public Command initializeCommand(Office office, Employee employee, OfficeManager officeManager){
    	addEmployeeCommand = new AddEmployeeCommand(office, employee, officeManager);
    	return addEmployeeCommand;
    }
}