package foo.bar.webapp.controller;

import org.apache.commons.lang.StringUtils;
import foo.bar.service.GenericManager;
import foo.bar.model.Quux;
import foo.bar.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/quuxform*")
public class QuuxFormController extends BaseFormController {
    private GenericManager<Quux, Long> quuxManager = null;

    @Autowired
    public void setQuuxManager(@Qualifier("quuxManager") GenericManager<Quux, Long> quuxManager) {
        this.quuxManager = quuxManager;
    }

    public QuuxFormController() {
        setCancelView("redirect:quuxs");
        setSuccessView("redirect:quuxs");
    }

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected Quux showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return quuxManager.get(new Long(id));
        }

        return new Quux();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Quux quux, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (quux.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            quuxManager.remove(quux.getId());
            saveMessage(request, getText("quux.deleted", locale));
        } else {
            quuxManager.save(quux);
            String key = (isNew) ? "quux.added" : "quux.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:quuxform?id=" + quux.getId();
            }
        }

        return success;
    }
}
