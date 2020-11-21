package webitm.ibase.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webitm.ibase.model.ExpenseVoucher;
import webitm.ibase.model.IncomeVoucher;
import webitm.ibase.model.JointMember;
import webitm.ibase.model.SocietyCommitteeMember;
import webitm.ibase.utility.HibernateUtility;
import webitm.ibase.utility.ITMException;

@Repository
public class GeetaPuramVoucherRepositoryImpl implements GeetaPuramVoucherRepository
{
	@Autowired
	private IncomeVoucher incomeVoucher;
	
	@Override
	public int saveIncomeVoucherRecords(IncomeVoucher incomeVoucher) throws ITMException 
	{
		boolean isError = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		int saveData = 0;
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			
			incomeVoucher.setIncVouchId(incomeVoucher.getIncVouchId());
			incomeVoucher.setIncVouchDate(incomeVoucher.getIncVouchDate());
			incomeVoucher.setIncVouchType(incomeVoucher.getIncVouchType());
			incomeVoucher.setIncVouchDescription(incomeVoucher.getIncVouchDescription());
			incomeVoucher.setIncVouchAmount(incomeVoucher.getIncVouchAmount());
			incomeVoucher.setIncVouchAmtRs(incomeVoucher.getIncVouchAmtRs());
			
			session.persist(incomeVoucher);
			saveData = 1;
			System.out.println("Data Saved Successfully In IncomeVoucher Table!!!");
			
		}
		catch(Exception e)
		{
			saveData = 0;
			tx.rollback();
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		finally
		{
			try
			{
				if(isError)
				{
					tx.rollback();
					session.flush();
					session.close();
				}
				else
				{
					tx.commit();
					session.flush();
					session.close();
				}
			}
			catch(Exception e)
			{
				saveData = 0;
				tx.rollback();
				System.out.println(e.getMessage());
				e.printStackTrace();
				throw new ITMException(e);
			}
		}
		return saveData;
	}

	@Override
	public List<IncomeVoucher> getAllIncomeVoucherData() throws ITMException, SQLException 
	{
		boolean isError = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		Criteria criteria = null;
		List<IncomeVoucher> incVouchList = null;
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			criteria = session.createCriteria(IncomeVoucher.class);			
			incVouchList = (ArrayList<IncomeVoucher>)criteria.list();
			System.out.println(incVouchList.isEmpty());
			Iterator<IncomeVoucher> incomeVoucherList = incVouchList.iterator();
			while(incomeVoucherList.hasNext())
			{
				IncomeVoucher myObj = incomeVoucherList.next();
				System.out.println(myObj.getIncVouchId() + "\t" + myObj.getIncVouchDescription());
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		finally
		{
			try
			{
				if(isError)
				{
					tx.rollback();
					session.flush();
					session.close();
				}
				else
				{
					tx.commit();
					session.flush();
					session.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				throw new ITMException(e);
			}
		}
		return incVouchList;
	}

	@Override
	public int saveExpenseVoucherRecords(ExpenseVoucher expenseVoucher) throws ITMException 
	{
		boolean isError = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		int saveData = 0;
		String sql = "";
		try
		{

			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			expenseVoucher.setExpVouchId(expenseVoucher.getExpVouchId());
			expenseVoucher.setExpVouchDate(expenseVoucher.getExpVouchDate());
			expenseVoucher.setExpVouchType(expenseVoucher.getExpVouchType());
			expenseVoucher.setExpVouchDescription(expenseVoucher.getExpVouchDescription());
			expenseVoucher.setExpVouchAmount(expenseVoucher.getExpVouchAmount());
			expenseVoucher.setExpVouchAmtRs(expenseVoucher.getExpVouchAmtRs());
			
			session.persist(expenseVoucher);
			saveData = 1;
			System.out.println("Data Saved Successfully In ExpenseVoucher Table!!!");
		}
		catch(Exception e)
		{
			saveData = 0;
			tx.rollback();
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		finally
		{

			try
			{
				if(isError)
				{
					tx.rollback();
					session.flush();
					session.close();
				}
				else
				{
					tx.commit();
					session.flush();
					session.close();
				}
			}
			catch(Exception e)
			{
				saveData = 0;
				tx.rollback();
				System.out.println(e.getMessage());
				e.printStackTrace();
				throw new ITMException(e);
			}
		
		}
		return saveData;
	}

	@Override
	public List<ExpenseVoucher> getAllExpenseVoucherData() throws ITMException, SQLException 
	{
		boolean isError = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		Criteria criteria = null;
		List<ExpenseVoucher> expVouchList = null;
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction(); 
			criteria = session.createCriteria(ExpenseVoucher.class);			
			expVouchList = (ArrayList<ExpenseVoucher>)criteria.list();
			System.out.println(expVouchList.isEmpty());
			Iterator<ExpenseVoucher> expenseVoucherList = expVouchList.iterator();
			while(expenseVoucherList.hasNext())
			{
				ExpenseVoucher myObj = expenseVoucherList.next();
				System.out.println(myObj.getExpVouchId() + "\t" + myObj.getExpVouchDescription());
			}
		}
		catch(Exception e)
		{
			isError = true;
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		finally
		{

			try
			{
				if(isError)
				{
					tx.rollback();
					session.flush();
					session.close();
				}
				else
				{
					tx.commit();
					session.flush();
					session.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				throw new ITMException(e);
			}
		}
		return expVouchList;
	}

}
