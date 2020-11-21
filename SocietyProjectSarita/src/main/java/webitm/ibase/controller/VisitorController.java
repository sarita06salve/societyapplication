package webitm.ibase.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import webitm.ibase.model.Visitors;
import webitm.ibase.service.GeetaPuramVisitorService;
import webitm.ibase.utility.ITMException;

@Controller
public class VisitorController 
{
	@Autowired
	private GeetaPuramVisitorService geetaPuramVisitorService;
	
	@RequestMapping("/home/visitorpage")
	public ModelAndView viewVisitorPage(Model model) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			model.addAttribute("addVisitorInfo", new Visitors());
			modelAndView.setViewName("VisitorAddPage");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/addVisitorInfo" , method = RequestMethod.GET)
	public ModelAndView addVisitorInfo(Model model) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			model.addAttribute("addVisitorInfo", new Visitors());
			modelAndView.setViewName("VisitorAddPage");
		}                       
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/addVisitorInfo" , method = RequestMethod.POST)
	public ModelAndView addVisitorInfo(@Valid @ModelAttribute("addVisitorInfo")Visitors visitors , Errors errors) throws ITMException , SQLException
	{
		ModelAndView modelAndView = new ModelAndView();
		int saveData = 0;
		List<Visitors> visitorList = new ArrayList<Visitors>();
		try
		{
			if(errors.hasErrors())
			{
				modelAndView.setViewName("VisitorAddPage");
			}
			else
			{
				saveData = geetaPuramVisitorService.saveVisitorRecords(visitors);
				System.out.println("Hi....255" + saveData);
				if(saveData > 0)
				{
					visitorList = geetaPuramVisitorService.getAllVisitorData();
					modelAndView.addObject("visitorList", visitorList);
					modelAndView.setViewName("showVisitorsInfo");
				}
				else
				{
					modelAndView.addObject("error", "Something is wrong while saving records!!!");
					modelAndView.setViewName("showVisitorsInfo");
				}
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

