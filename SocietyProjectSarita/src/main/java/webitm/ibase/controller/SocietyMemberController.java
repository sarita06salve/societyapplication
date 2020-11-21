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

import webitm.ibase.model.JointMember;
import webitm.ibase.model.SocietyMember;
import webitm.ibase.model.Vehicle;
import webitm.ibase.service.GeetaPuramSocietyMemberService;
import webitm.ibase.utility.ITMException;

@Controller
public class SocietyMemberController 
{
	@Autowired
	private GeetaPuramSocietyMemberService geetaPuramSocietyMemberService;
	
	@RequestMapping("/home/adsSocietyMember")
	public ModelAndView getSocietyMemberPage(Model modelMap) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			System.out.println("Hi,....12345");
			modelMap.addAttribute("societymembermodel", new SocietyMember());
			modelMap.addAttribute("jointmembermodel", new JointMember());
			
			modelAndView.setViewName("societyMemberAddPage");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/saveMember" , method = RequestMethod.GET)
	public ModelAndView saveSocietyMember(Model modelMap) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			System.out.println("Hi,....123456..");
			modelMap.addAttribute("societymembermodel", new SocietyMember());
			modelMap.addAttribute("jointmembermodel", new JointMember());
			
			modelAndView.setViewName("societyMemberAddPage");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
		
	@RequestMapping(value = "/home/saveMember" , method = RequestMethod.POST)
	public ModelAndView saveSocietyMember(
			                              @Valid  @ModelAttribute("societymembermodel")SocietyMember societyMember , Errors socmemerros ,
			                              @Valid  @ModelAttribute("jointmembermodel")JointMember jointMember , Errors joinmemerror
			                              ) throws ITMException,SQLException
	{
		ModelAndView modelAndView = new ModelAndView();
		List<SocietyMember> socMemList = new ArrayList<SocietyMember>();
		
		try
		{
			if(socmemerros.hasErrors())
			{
				System.out.println("Hey... Error in SocietyMember Page..");
				System.out.println(societyMember.getMember_firstName());
				modelAndView.setViewName("societyMemberAddPage");
			}
			if(joinmemerror.hasErrors())
			{
				System.out.println("Hey... Error in Joint Member Page..");
				System.out.println(jointMember.getJointMember_firstName() + "\t" + jointMember.getJointMember_maiden());
				modelAndView.setViewName("societyMemberAddPage");
			}
			else
			{
				System.out.println("Hey... No I am Here...");	
				geetaPuramSocietyMemberService.saveSocietyMemRecords(societyMember, jointMember);
				socMemList = geetaPuramSocietyMemberService.getAllData();
				
				modelAndView.setViewName("societyMemberAddPage");
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
