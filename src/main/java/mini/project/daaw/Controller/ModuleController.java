package mini.project.daaw.Controller;


import mini.project.daaw.Model.Module;
import mini.project.daaw.Model.ModuleDAO;
import mini.project.daaw.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ModuleController {

    @GetMapping("/getModulePage")
    public String getModulePage(HttpServletRequest request, @RequestParam String module, Model model) throws InstantiationException, IllegalAccessException {
        if (request.getSession().getAttribute("user") != null) {
            ModuleDAO moduleDAO = new ModuleDAO();
            ArrayList<Module> list = new ArrayList<Module>();
            ArrayList<Module> list2 = new ArrayList<Module>();
            Module module1 = new Module(module,"","","","","");
            list = moduleDAO.getModules(module);
            if(list.size() != 0) {
                list2.add(module1);
                model.addAttribute("list", list2);
                model.addAttribute("info", list);
            }else{

                list2.add(module1);
                model.addAttribute("list", list2);
            }
            User user = (User) request.getSession().getAttribute("user");
            HttpSession mySession = request.getSession();
            mySession.setAttribute("user", user);
            model.addAttribute("user", user);

            return "module";
        }else{
            return "login";
        }
    }



    @PostMapping("/addModule")
    public String addModule(HttpServletRequest request, @ModelAttribute("newModule") Module newModule, Model model) throws InstantiationException, IllegalAccessException {
        if (request.getSession().getAttribute("user") != null) {
            ModuleDAO moduleDAO = new ModuleDAO();
            if(moduleDAO.getModule(newModule.getPdfName(), newModule.getType())){
                moduleDAO.updateModule(newModule);
            }else{
                moduleDAO.addModule(newModule);
            }
            ArrayList<Module> list = new ArrayList<Module>();
            ArrayList<Module> list2 = new ArrayList<Module>();
            list = moduleDAO.getModules(newModule.getModuleName());
            Module module1 = new Module(newModule.getModuleName(),"","","","","");

            if(list.size() != 0) {
                list2.add(module1);
                model.addAttribute("list", list2);
                model.addAttribute("info", list);
            }else{

                list2.add(module1);
                model.addAttribute("list", list2);
            }
            return "module";
        }else{
            return "login";
        }
    }

    @PostMapping("/deleteModule")
    public String deleteModule(HttpServletRequest request, @RequestParam String pdfName, @RequestParam String type, @RequestParam String module, Model model) throws InstantiationException, IllegalAccessException {
        if (request.getSession().getAttribute("user") != null) {
            ModuleDAO moduleDAO = new ModuleDAO();
            moduleDAO.deleteModule(pdfName, type);
            ArrayList<Module> list = new ArrayList<Module>();
            ArrayList<Module> list2 = new ArrayList<Module>();
            list = moduleDAO.getModules(module);
            Module module1 = new Module(module,"","","","","");

            if(list.size() != 0) {
                list2.add(module1);
                model.addAttribute("list", list2);
                model.addAttribute("info", list);
            }else{
                list2.add(module1);
                model.addAttribute("list", list2);
            }
            return "module";
        }else{
            return "login";
        }
    }


}
