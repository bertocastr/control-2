package es.unileon.ulebank.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {

		HomeController controller = new HomeController();
		
		ModelAndView modelAndView = controller.handleRequest(null, null);
		
		assertEquals("home", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
	
	}

}