package webitm.ibase.repository;

import java.sql.SQLException;
import java.util.List;

import webitm.ibase.model.ExpenseVoucher;
import webitm.ibase.model.IncomeVoucher;
import webitm.ibase.utility.ITMException;


public interface GeetaPuramVoucherRepository 
{
	public int saveIncomeVoucherRecords(IncomeVoucher incomeVoucher) throws ITMException;
	public List<IncomeVoucher> getAllIncomeVoucherData() throws ITMException,SQLException;
	
	public int saveExpenseVoucherRecords(ExpenseVoucher expenseVoucher) throws ITMException;
	public List<ExpenseVoucher> getAllExpenseVoucherData() throws ITMException,SQLException;
}
