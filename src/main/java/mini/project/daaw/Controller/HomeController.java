package mini.project.daaw.Controller;


import mini.project.daaw.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
	

	@GetMapping("/")
	public String home(HttpServletRequest request){
		if(request.getSession().getAttribute("user") != null){
			request.setAttribute("home", true);
		}else{
			request.setAttribute("home", false);
		}
		return ("index");
	}
}
