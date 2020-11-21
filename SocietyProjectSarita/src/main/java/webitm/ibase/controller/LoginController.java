package webitm.ibase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webitm.ibase.utility.ITMException;

@Controller
public class LoginController 
{
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
		
	@RequestMapping(value = "/home/login" , method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username")String username , @RequestParam("password")String password) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			System.out.println(username + "\t" + password);
			if(("ADMIN".equals(username)) && ("Admin@555".equals(password)))
			{
				modelAndView.setViewName("socirtyactivitylist");
			}
			else if((username == null || username.trim().length()==0) && 
					(password == null || password.trim().length() == 0))
			{
				modelAndView.addObject("error", "Username Or Password Can't Be Blank!!!");
				modelAndView.setViewName("home");
			}
			else
			{
				modelAndView.addObject("error", "Username Or Password is Wrong!!!");
				modelAndView.setViewName("home");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new ITMException(e);
		}
		return modelAndView;
	}
}
