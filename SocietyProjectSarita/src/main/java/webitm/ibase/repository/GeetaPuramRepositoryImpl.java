package webitm.ibase.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webitm.ibase.model.SocietyCommitteeMember;
import webitm.ibase.utility.HibernateUtility;
import webitm.ibase.utility.ITMException;

@Repository
public class GeetaPuramRepositoryImpl implements GeetaPuramRepository
{
	@Autowired
	SocietyCommitteeMember committeeMember;
	
	@Override
	public int saveCommitteeMemRecords(SocietyCommitteeMember committeeMember) throws ITMException 
	{
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		boolean isError = false;
		int saveData = 0;
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			String maiden = committeeMember.getMaiden();
			String scm_firstName = committeeMember.getScm_firstName();
			String scm_middleName = committeeMember.getScm_middleName();
			String scm_lastName = committeeMember.getScm_lastName();
			String scm_mobileNo = committeeMember.getScm_mobileNo();
			String scm_designation = committeeMember.getScm_designation();
			System.out.println(scm_firstName + "\t" + scm_middleName + "\t" + scm_lastName + "\t" + scm_mobileNo + "\t" + scm_designation);
			
			committeeMember.setMaiden(maiden);
			committeeMember.setScm_firstName(scm_firstName);
			committeeMember.setScm_middleName(scm_middleName);
			committeeMember.setScm_lastName(scm_lastName);
			committeeMember.setScm_mobileNo(scm_mobileNo);
			committeeMember.setScm_designation(scm_designation);
			
			session.persist(committeeMember);
			saveData = 1;
			System.out.println("Data Saved Successfully!!!");
		}
		catch(Exception e)
		{
			isError = true;
			saveData = 0;
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
		return saveData;
	}

	@Override
	public List<SocietyCommitteeMember> getAllData() throws ITMException,SQLException 
	{
		List<SocietyCommitteeMember> memberList = new ArrayList<SocietyCommitteeMember>();
		boolean isError = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		Criteria criteria = null;
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			criteria = session.createCriteria(SocietyCommitteeMember.class);			
			memberList = (ArrayList<SocietyCommitteeMember>)criteria.list();
			System.out.println(memberList.isEmpty());
			Iterator<SocietyCommitteeMember> memberListItr = memberList.iterator();
			while(memberListItr.hasNext())
			{
				SocietyCommitteeMember myObj = memberListItr.next();
				System.out.println(myObj.getScmId() + "\t" + myObj.getScm_designation());
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
		return memberList;
	}

	@Override
	public int updateSocietyMemRecords(SocietyCommitteeMember committeeMember) throws ITMException, SQLException 
	{
		boolean isError = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		String sql = "";
		int updateData = 0;
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			sql = "update "
				+ "SocietyCommitteeMember "
				+ "set "
				+ "scm_firstName=:firstname , "
				+ "scm_middleName=:middleName , "
				+ "scm_lastName=:lastName , "
				+ "scm_mobileNo=:mobileNo where scmId=:id";
			Query query = session.createQuery(sql);
			query.setParameter("firstname", committeeMember.getScm_firstName());
			query.setParameter("middleName", committeeMember.getScm_middleName());
			query.setParameter("lastName", committeeMember.getScm_lastName());
			query.setParameter("mobileNo", committeeMember.getScm_mobileNo());
			query.setParameter("id", committeeMember.getScmId());
			
			updateData = query.executeUpdate();
			if(updateData > 0)
			{
				isError = false;
			}
			else
			{
				isError = true;
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
		return updateData;
	}

	@Override
	public SocietyCommitteeMember getMemberDataById(int scmId) throws ITMException, SQLException 
	{
		boolean isError = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		String sql = "";
		List<SocietyCommitteeMember> listById = new ArrayList<SocietyCommitteeMember>();		
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			sql = "from SocietyCommitteeMember where scmId=:id";
			Query query = session.createQuery(sql);
			query.setParameter("id", scmId);
			
			listById = query.list();
		    
			if(listById == null)
			{
				isError = true;
			}
			else
			{
				System.out.println(listById.toString());
				Iterator<SocietyCommitteeMember> itr = listById.iterator();
				while(itr.hasNext())
				{
					SocietyCommitteeMember member = itr.next();
					committeeMember.setScmId(member.getScmId());
					committeeMember.setMaiden(member.getMaiden());
					committeeMember.setScm_firstName(member.getScm_firstName());
					committeeMember.setScm_middleName(member.getScm_middleName());
					committeeMember.setScm_lastName(member.getScm_lastName());
					committeeMember.setScm_mobileNo(member.getScm_mobileNo());
					committeeMember.setScm_designation(member.getScm_designation());
					System.out.println(member.getScmId() + "\t" + member.getMaiden() + "\t" + member.getScm_firstName() + member.getScm_lastName() + member.getScm_designation());
				}
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
		return committeeMember;
	}

}
