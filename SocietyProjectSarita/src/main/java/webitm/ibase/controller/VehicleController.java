package webitm.ibase.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webitm.ibase.model.SocietyMember;
import webitm.ibase.model.Vehicle;
import webitm.ibase.service.GeetaPuramVehicleService;
import webitm.ibase.utility.ITMException;

@Controller
public class VehicleController 
{
	@Autowired
	private GeetaPuramVehicleService geetaPuramVehicleService;
	
	@RequestMapping("/home/addVehicle")
	public ModelAndView getVehiclePage(Model model)
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			model.addAttribute("vehicleInfo", new Vehicle());
			model.addAttribute("memberInfo", new SocietyMember());
			modelAndView.setViewName("addVehiclePage");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/getMemDataById/{memberId}" , method = RequestMethod.GET) 
	public String getMemInfoById(@PathVariable("memberId") String memberId , Model model)
	{
		ModelAndView modelAndView = new ModelAndView();
		JSONObject societyMemdata = new JSONObject();
		String data = "";
		try
		{
			model.addAttribute("vehicleInfo", new Vehicle());
			model.addAttribute("memberInfo", new SocietyMember());
			
			System.out.println("Value of Member Id is :::::" +memberId);
			societyMemdata = geetaPuramVehicleService.getMemberDataById(Integer.valueOf(memberId));
			System.out.println("123456" + societyMemdata);
			data = societyMemdata.getString("memFirstName") + "\t" + societyMemdata.getString("memMiddleName") + "\t" + societyMemdata.getString("memLastName");
			
			//modelAndView.addObject("socMember", societyMemdata);
			//modelAndView.setViewName("addVehiclePage");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return data;
	}
	
	/*@RequestMapping(value = "/home/getMemDataById/{memberId}" , method = RequestMethod.POST) 
	public ModelAndView getMemInfoById(@PathVariable("memberId") String memberId)
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			System.out.println("Value of Member Id is :::::" +memberId);
			
			modelAndView.setViewName("addVehiclePage");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return modelAndView;
	}*/
	
	@RequestMapping(value = "/home/saveVehicle" , method = RequestMethod.GET)
	public ModelAndView saveVehicleInformation(Model model) throws SQLException , ITMException 
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			model.addAttribute("vehicleInfo", new Vehicle());
			model.addAttribute("memberInfo", new SocietyMember());
			modelAndView.setViewName("addVehiclePage");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
            throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/saveVehicle" , method = RequestMethod.POST)
	public ModelAndView saveVehicleInformation(@Valid @ModelAttribute("vehicleInfo")Vehicle vehicle , Errors errors ,			                                          
			                                          @ModelAttribute("memberInfo")SocietyMember societyMember) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			if(errors.hasErrors())
			{
				System.out.println("Getting Error in Vehicle Form...");
				modelAndView.setViewName("addVehiclePage");
			}
			else
			{
				System.out.println("Form doesn't have any error..");
				System.out.println(vehicle.getTypeOfVehicle() + "\n" + 
				                   vehicle.getNoOfVehicle() + "\n" + 
						           vehicle.getVehicleNo() + "\n" + 
				                   societyMember.getMemberId());
				modelAndView.setViewName("addVehiclePage");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
            throw new ITMException(e);
		}
		return modelAndView;
	}
}
