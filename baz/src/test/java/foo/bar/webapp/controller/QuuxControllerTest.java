package foo.bar.webapp.controller;

import foo.bar.webapp.controller.BaseControllerTestCase;
import org.compass.gps.CompassGps;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuuxControllerTest extends BaseControllerTestCase {
    @Autowired
    private CompassGps compassGps;
    @Autowired
    private QuuxController controller;

    @Test
    public void testHandleRequest() throws Exception {
        ModelAndView mav = controller.handleRequest(null);
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("quuxList"));
        assertTrue(((List) m.get("quuxList")).size() > 0);
    }

//    @Test
//    public void testSearch() throws Exception {
//        compassGps.index();
//        ModelAndView mav = controller.handleRequest("*");
//        Map m = mav.getModel();
//        List results = (List) m.get("quuxList");
//        assertNotNull(results);
//        assertEquals(3, results.size());
//    }
}
