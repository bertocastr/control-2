package es.unileon.ulebank.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class StartControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {

		StartController controller = new StartController();
		
		ModelAndView modelAndView = controller.handleRequest(null, null);
		
		assertEquals("startpage", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
	
	}

}