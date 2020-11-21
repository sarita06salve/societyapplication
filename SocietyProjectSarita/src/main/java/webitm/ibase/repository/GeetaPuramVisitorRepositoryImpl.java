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

import webitm.ibase.model.Visitors;
import webitm.ibase.utility.HibernateUtility;
import webitm.ibase.utility.ITMException;

@Repository
public class GeetaPuramVisitorRepositoryImpl implements GeetaPuramVisitorRepository
{
	@Autowired
	private Visitors visitors;
	
	@Override
	public int saveVisitorRecords(Visitors visitors) throws ITMException , SQLException
	{
		int saveData = 0;
		boolean isError = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			session.persist(visitors);
			saveData = 1;
		}
		catch(Exception e)
		{
			saveData = 0;
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
	public List<Visitors> getAllVisitorData() throws ITMException, SQLException 
	{
		boolean isError = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		Criteria criteria = null;
		List<Visitors> visitorList = null;
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			criteria = session.createCriteria(Visitors.class);			
			visitorList = (ArrayList<Visitors>)criteria.list();
			System.out.println(visitorList.isEmpty());
			Iterator<Visitors> allVisitorList = visitorList.iterator();
			while(allVisitorList.hasNext())
			{
				Visitors myObj = allVisitorList.next();
				System.out.println(myObj.getVisitorId() + "\t" + myObj.getVistiotorName());
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
				tx.rollback();
				System.out.println(e.getMessage());
				e.printStackTrace();
				throw new ITMException(e);
			}
		
		}
		return visitorList;
	}
}
