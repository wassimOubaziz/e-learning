package mini.project.daaw.Controller;

import mini.project.daaw.Model.User;
import mini.project.daaw.Model.UserDAO;
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
public class UserController {

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam String deleteEmail, Model model, HttpServletRequest request) throws InstantiationException, IllegalAccessException{
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUser(deleteEmail);

        User user = (User) request.getSession().getAttribute("user");
        HttpSession mySession = request.getSession();
        mySession.setAttribute("user", user);
        model.addAttribute("user", user);
        ArrayList<User> list = new ArrayList<User>();
        list = userDAO.getUsers();
        model.addAttribute("list", list);
        return "adminPage";

    }
    
    public boolean isTrue(User newUser, UserDAO myDAO) throws InstantiationException, IllegalAccessException{
        for (int i = 0; i < myDAO.getUsers().size(); i++) {
            if(myDAO.getUsers().get(i).getEmail().contains(newUser.getEmail())) return true;
        }
        return false;
    }
    
    @PostMapping("/addUpdateUser")
    public String addUpdateUser(HttpServletRequest request, @ModelAttribute("newUser") User newUser, Model model) throws InstantiationException, IllegalAccessException {
        if (request.getSession().getAttribute("user") != null) {

            UserDAO myDAO = new UserDAO();
            boolean a = isTrue(newUser, myDAO);
            if(a) {
                myDAO.updateUser(newUser.getEmail(), newUser.getPassword(), newUser.getPhone(), newUser.getSurname(), newUser.getName(), newUser.getRole(), newUser.getUser_name(), newUser.getModule());
            }else{
                myDAO.addUser(newUser);
            }

            User user = (User) request.getSession().getAttribute("user");
            HttpSession mySession = request.getSession();
            mySession.setAttribute("user", user);
            model.addAttribute("user", user);
            ArrayList<User> list = new ArrayList<User>();
            list = myDAO.getUsers();
            model.addAttribute("list", list);
            return "adminPage";
        } else
            return ("login");

    }

    //////Edit profile Page ///////
    @GetMapping("/editePage")
    public String getEditePage(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            return "editeProfile";
        }else{
            return "login";
        }
    }
    ////////
    @PostMapping("/editePage")
    public String editePage(HttpServletRequest request, @ModelAttribute("newUser") User newUser, Model model) throws InstantiationException, IllegalAccessException {
        if (request.getSession().getAttribute("user") != null) {
            UserDAO myDAO = new UserDAO();
            myDAO.updateUser(newUser.getEmail(), newUser.getPassword(), newUser.getPhone(), newUser.getSurname(), newUser.getName(), newUser.getRole(), newUser.getUser_name(), newUser.getModule());
            HttpSession mySession = request.getSession();
            mySession.setAttribute("user", newUser);
            model.addAttribute("user", newUser);
            if(newUser.getRole().equals("admin")){
                ArrayList<User> list = new ArrayList<User>();
                list = myDAO.getUsers();
                model.addAttribute("list", list);
                return "adminPage";
            } else if (newUser.getRole().equals("teacher")) {
                String module = newUser.getModule();
                String[] modules = module.split(",");
                ArrayList<String> listModule = new ArrayList<String>();
                for (int i = 0; i < modules.length; i++) {
                    listModule.add(modules[i]);
                }
                model.addAttribute("listModule", listModule);
                return "teacherPage";
            }else{
                return "studentPage";
            }
        }else{
            return "login";
        }
    }





    /////////////End Profile/////////////







    ///////filtering users by username ////////

    @PostMapping("/filteringUsers")
    public String filteringUsers(@RequestParam String filterStr, Model model, HttpServletRequest request) throws InstantiationException, IllegalAccessException{
        UserDAO userDAO = new UserDAO();
        if(request.getSession().getAttribute("user") != null) {
            User user = (User) request.getSession().getAttribute("user");
            HttpSession mySession = request.getSession();
            mySession.setAttribute("user", user);
            model.addAttribute("user", user);
            ArrayList<User> list = new ArrayList<User>();
            list = userDAO.filterUsers(filterStr);
            if(list.size() != 0) {
                model.addAttribute("list", list);
            }else{
                list.add(0, user);
                model.addAttribute("list", list);
            }
            return "adminPage";
        }
        return "login";

    }


}