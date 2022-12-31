package mini.project.daaw.Controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mini.project.daaw.Model.User;
import mini.project.daaw.Model.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class LoginController {



    @PostMapping("/home")
    public String login(HttpServletRequest request, Model model, @RequestParam String email, @RequestParam String password)
            throws InstantiationException, IllegalAccessException {

        String page = "login";

        if (request.getSession(false).getAttribute("user") == null) {
            UserDAO myDAO = new UserDAO();
            User user = myDAO.checkLogin(email, password);
            if (user != null) {
                HttpSession mySession = request.getSession();
                mySession.setAttribute("user", user);
                model.addAttribute("user", user);
                if(user.getRole().equals("admin")){
                    ArrayList<User> list = new ArrayList<User>();
                    list = myDAO.getUsers();
                    model.addAttribute("list", list);
                    page = "adminPage";
                }else {
                    String module = user.getModule();
                    String[] modules = module.split(",");
                    ArrayList<String> listModule = new ArrayList<String>();
                    for (int i = 0; i < modules.length; i++) {
                        listModule.add(modules[i]);
                    }
                    model.addAttribute("listModule", listModule);
                    page = "teacherPage";
                }

            }else {
                page = "login";
            }
        }
        return page;

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws InstantiationException, IllegalAccessException {

        HttpSession mySession = request.getSession(false);
        mySession.removeAttribute("user");
        mySession.invalidate();

        return ("login");

    }

    @GetMapping("/login")
    public String getLoginPage(HttpServletRequest request, Model model) throws InstantiationException, IllegalAccessException {
        if (request.getSession(false).getAttribute("user") == null) {
            return ("login");
        }else{
            User user = (User) request.getSession().getAttribute("user");
                HttpSession mySession = request.getSession();
                UserDAO myDAO = new UserDAO();
                mySession.setAttribute("user", user);
                model.addAttribute("user", user);
                if(user.getRole().equals("admin")){
                    ArrayList<User> list = new ArrayList<User>();
                    list = myDAO.getUsers();
                    model.addAttribute("list", list);
                    return "adminPage";
                }else {
                    String module = user.getModule();
                    String[] modules = module.split(",");
                    ArrayList<String> listModule = new ArrayList<String>();
                    for (int i = 0; i < modules.length; i++) {
                        listModule.add(modules[i]);
                    }
                    model.addAttribute("listModule", listModule);
                    return "teacherPage";
                }
      }
    }
}