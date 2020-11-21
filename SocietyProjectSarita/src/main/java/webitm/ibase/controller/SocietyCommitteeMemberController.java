package webitm.ibase.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import webitm.ibase.model.SocietyCommitteeMember;
import webitm.ibase.service.GeetaPuramService;
import webitm.ibase.utility.ITMException;

@Controller
public class SocietyCommitteeMemberController 
{
	@Autowired
	private GeetaPuramService geetaPuramService;
	
	@Autowired
	private SocietyCommitteeMember committeemember;
	
	@RequestMapping("/home/societyactivitylist")
	public ModelAndView getSocietyCommitteeMemberPage(Model model) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			System.out.println("Hi,....123");
			model.addAttribute("saveComMember" , new SocietyCommitteeMember());
			modelAndView.setViewName("addSocCommitterMember");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/home/saveComMember" , method = RequestMethod.GET)
	public ModelAndView saveSocietyCommitteMember(Model model) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			System.out.println("Hi,....");
			model.addAttribute("saveComMember" , new SocietyCommitteeMember());
			modelAndView.setViewName("addSocCommitterMember");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/home/saveComMember" , method = RequestMethod.POST)
	public ModelAndView saveSocietyCommitteMember(@Valid @ModelAttribute("saveComMember")SocietyCommitteeMember committeeMember , Errors errors) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		int saveData = 0;
		List<SocietyCommitteeMember> memberList = new ArrayList<SocietyCommitteeMember>();
		try
		{
			if(errors.hasErrors())
			{
				modelAndView.setViewName("addSocCommitterMember");
			}
			else
			{
				System.out.println(committeeMember.getMaiden());
				saveData = geetaPuramService.saveCommitteeMemberRecord(committeeMember);
				memberList = geetaPuramService.getAllData();
				System.out.println("MemberList Data :::" + memberList);
				modelAndView.addObject("memberList", memberList);
				modelAndView.setViewName("showUpdateCommitteeMemData");
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
	
	@RequestMapping(value="/home/getMemberDataById/{scmId}" , method = RequestMethod.GET)
	public  ModelAndView getMemberById(@PathVariable("scmId")int scmId , SocietyCommitteeMember committeemember) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			System.out.println("Inside updateSocietyCommitteMember123..");
			System.out.println("Update Data:::" + "123" + "\t" + scmId + "\t" );
			committeemember = geetaPuramService.getMemberDataById(scmId);
			
			
			modelAndView.addObject("committeemember", committeemember);
			modelAndView.setViewName("updateSocCommitteeMemData");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}	
	
	@RequestMapping(value="/home/updateSocMemData" , method = RequestMethod.GET)
	public ModelAndView updateSocietyCommitteMember(Model model) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			System.out.println("Hi,....");
			model.addAttribute("committeemember" , new SocietyCommitteeMember());
			modelAndView.setViewName("updateSocCommitteeMemData");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/home/updateSocMemData" , method = RequestMethod.POST)
	public ModelAndView updateSocietyCommitteMember(@Valid @ModelAttribute("committeemember")SocietyCommitteeMember committeeMember , Errors errors) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		List<SocietyCommitteeMember> memberList = new ArrayList<SocietyCommitteeMember>();
		int updateData = 0;
		try
		{
			if(errors.hasErrors())
			{
				modelAndView.setViewName("showUpdateCommitteeMemData");
			}
			else
			{
				System.out.println(committeeMember.getScmId() + "\t" + committeeMember.getScm_firstName());
				updateData = geetaPuramService.updateSocietyMemRecords(committeeMember);
				System.out.println("Data Updated Successfully!!! ["+updateData+"]");
				if(updateData > 0)
				{
					memberList = geetaPuramService.getAllData();
					modelAndView.addObject("memberList", memberList);
					modelAndView.setViewName("showUpdateCommitteeMemData");
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
