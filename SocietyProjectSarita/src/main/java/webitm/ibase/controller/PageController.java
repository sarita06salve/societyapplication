package webitm.ibase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController 
{
	@RequestMapping(value = "/home/loginPage")
	public String getLoginPage()
	{
		return "socirtyactivitylist";
	}
}
