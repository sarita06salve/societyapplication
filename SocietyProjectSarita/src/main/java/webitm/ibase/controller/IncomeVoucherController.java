package webitm.ibase.controller;

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
import webitm.ibase.model.IncomeVoucher;
import webitm.ibase.model.SocietyCommitteeMember;
import webitm.ibase.service.GeetaPuramVoucherService;
import webitm.ibase.utility.ITMException;

@Controller
public class IncomeVoucherController 
{
	
	@Autowired
	private GeetaPuramVoucherService geetaPuramVoucherService;
	
	@RequestMapping("/home/incomeVoucher")
	public ModelAndView viewIncomeVoucher(Model model) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			model.addAttribute("addIncVoucher", new IncomeVoucher());
			modelAndView.setViewName("incomeVoucher");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/addIncVoucher" , method = RequestMethod.GET)
	public ModelAndView addIncomeVoucher(Model model) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			model.addAttribute("addIncVoucher", new IncomeVoucher());
			modelAndView.setViewName("incomeVoucher");
		}                       
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/addIncVoucher" , method = RequestMethod.POST)
	public ModelAndView addIncomeVoucher(@Valid @ModelAttribute("addIncVoucher")IncomeVoucher incomeVoucher , Errors errors) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		int saveData = 0;
		List<IncomeVoucher> incomeVoucherList = new ArrayList<IncomeVoucher>();
		try
		{
			if(errors.hasErrors())
			{
				modelAndView.setViewName("incomeVoucher");
			}
			else
			{
				saveData = geetaPuramVoucherService.saveIncomeVoucherRecords(incomeVoucher);
				System.out.println("Hi....255" + saveData);
				if(saveData > 0)
				{
					incomeVoucherList = geetaPuramVoucherService.getAllIncomeVoucherData();
					modelAndView.addObject("incomeVoucherList", incomeVoucherList);
					modelAndView.setViewName("showIncomeVoucherInfo");
				}
				else
				{
					modelAndView.addObject("error", "Something is wrong while saving records!!!");
					modelAndView.setViewName("incomeVoucher");
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
