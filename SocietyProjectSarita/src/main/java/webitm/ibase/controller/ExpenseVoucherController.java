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
import webitm.ibase.model.ExpenseVoucher;
import webitm.ibase.model.IncomeVoucher;
import webitm.ibase.service.GeetaPuramVoucherService;
import webitm.ibase.utility.ITMException;

@Controller
public class ExpenseVoucherController 
{
	@Autowired
	private GeetaPuramVoucherService geetaPuramVoucherService;
	
	@RequestMapping("/home/expenseVoucher")
	public ModelAndView viewIncomeVoucher(Model model) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			model.addAttribute("addExpVoucher", new ExpenseVoucher());
			modelAndView.setViewName("expenseVoucher");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/addExpVoucher" , method = RequestMethod.GET)
	public ModelAndView addExpenseVoucher(Model model) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			model.addAttribute("addExpVoucher", new ExpenseVoucher());
			modelAndView.setViewName("expenseVoucher");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/addExpVoucher" , method = RequestMethod.POST)
	public ModelAndView addExpenseVoucher(@Valid @ModelAttribute("addExpVoucher")ExpenseVoucher expenseVoucher , Errors errors) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		int saveData = 0;
		List<ExpenseVoucher> expenseVoucherList = new ArrayList<ExpenseVoucher>();
		try
		{
			if(errors.hasErrors())
			{
				System.out.println("1111" + expenseVoucher.getExpVouchDate());
				modelAndView.setViewName("expenseVoucher");
			}
			else
			{
				System.out.println("2222" + expenseVoucher.getExpVouchDate());
				saveData = geetaPuramVoucherService.saveExpenseVoucherRecords(expenseVoucher);
				if(saveData > 0)
				{
					expenseVoucherList = geetaPuramVoucherService.getAllExpenseVoucherData();
					modelAndView.addObject("expenseVoucherList", expenseVoucherList);
					modelAndView.setViewName("showExpenseVoucherInfo");
				}
				else
				{
					System.out.println("2223" + expenseVoucher.getExpVouchDate());
					modelAndView.addObject("error", "Something is wrong while saving records!!!");
					modelAndView.setViewName("expenseVoucher");
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
