package webitm.ibase.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webitm.ibase.model.ExpenseVoucher;
import webitm.ibase.model.IncomeVoucher;
import webitm.ibase.repository.GeetaPuramVoucherRepository;
import webitm.ibase.utility.ITMException;

@Service
public class GeetaPuramVoucherServiceImpl implements GeetaPuramVoucherService
{
	@Autowired
	private GeetaPuramVoucherRepository geetaPuramVoucherRepository;
	
	
	@Override
	public int saveIncomeVoucherRecords(IncomeVoucher incomeVoucher) throws ITMException
	{
		int saveData = 0;
		try
		{
			saveData = geetaPuramVoucherRepository.saveIncomeVoucherRecords(incomeVoucher);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return saveData;
	}

	@Override
	public List<IncomeVoucher> getAllIncomeVoucherData() throws ITMException, SQLException
	{
		List<IncomeVoucher> incomeVoucherList = new ArrayList<IncomeVoucher>();
		try
		{
			incomeVoucherList = geetaPuramVoucherRepository.getAllIncomeVoucherData();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return incomeVoucherList;
	}

	@Override
	public int saveExpenseVoucherRecords(ExpenseVoucher expenseVoucher) throws ITMException 
	{
		int saveData = 0;
		try
		{
			saveData = geetaPuramVoucherRepository.saveExpenseVoucherRecords(expenseVoucher);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return saveData;
	}

	@Override
	public List<ExpenseVoucher> getAllExpenseVoucherData() throws ITMException, SQLException 
	{
		List<ExpenseVoucher> expenseVoucherList = new ArrayList<ExpenseVoucher>();

		try
		{
			expenseVoucherList = geetaPuramVoucherRepository.getAllExpenseVoucherData();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return expenseVoucherList;
	}

}
