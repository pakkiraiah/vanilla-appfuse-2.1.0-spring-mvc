package foo.bar.webapp.controller;

import foo.bar.webapp.controller.BaseControllerTestCase;
import foo.bar.model.Quux;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuuxFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private QuuxFormController form;
    private Quux quux;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/quuxform");
        request.addParameter("id", "-1");

        quux = form.showForm(request);
        assertNotNull(quux);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/quuxform");
        request.addParameter("id", "-1");

        quux = form.showForm(request);
        assertNotNull(quux);

        request = newPost("/quuxform");

        quux = form.showForm(request);
        // update required fields

        BindingResult errors = new DataBinder(quux).getBindingResult();
        form.onSubmit(quux, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/quuxform");
        request.addParameter("delete", "");
        quux = new Quux();
        quux.setId(-2L);

        BindingResult errors = new DataBinder(quux).getBindingResult();
        form.onSubmit(quux, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
