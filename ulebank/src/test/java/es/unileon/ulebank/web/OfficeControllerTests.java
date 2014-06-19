package es.unileon.ulebank.web;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.domain.Employee;
import es.unileon.ulebank.domain.Office;
import es.unileon.ulebank.repository.InMemoryOfficeDao;
import es.unileon.ulebank.service.SimpleOfficeManager;;

public class OfficeControllerTests {

    @Test
    public void testHandleRequestView() throws Exception {
    	
        OfficeController controller = new OfficeController();
        SimpleOfficeManager spm = new SimpleOfficeManager();
        
        spm.setOfficeDao(new InMemoryOfficeDao(new ArrayList<Office>(), new ArrayList<Employee>()));
        
        controller.setOfficeManager(spm);
        ModelAndView modelAndView = controller.handleRequest(null, null);
        
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);

    }

}