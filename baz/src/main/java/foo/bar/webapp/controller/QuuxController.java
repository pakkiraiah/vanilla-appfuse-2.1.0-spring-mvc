package foo.bar.webapp.controller;

import foo.bar.service.GenericManager;
import foo.bar.model.Quux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quuxs*")
public class QuuxController {
    private GenericManager<Quux, Long> quuxManager;

    @Autowired
    public void setQuuxManager(@Qualifier("quuxManager") GenericManager<Quux, Long> quuxManager) {
        this.quuxManager = quuxManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        return new ModelAndView().addObject(quuxManager.search(query, Quux.class));
    }
}
