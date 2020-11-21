package webitm.ibase.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import webitm.ibase.model.ExpenseVoucher;
import webitm.ibase.model.IncomeVoucher;
import webitm.ibase.model.Visitors;
import webitm.ibase.utility.ITMException;


public interface GeetaPuramVoucherService 
{
	public int saveIncomeVoucherRecords(IncomeVoucher incomeVoucher) throws ITMException;
	public List<IncomeVoucher> getAllIncomeVoucherData() throws ITMException,SQLException;
	
	public int saveExpenseVoucherRecords(ExpenseVoucher expenseVoucher) throws ITMException;
	public List<ExpenseVoucher> getAllExpenseVoucherData() throws ITMException,SQLException;
}
