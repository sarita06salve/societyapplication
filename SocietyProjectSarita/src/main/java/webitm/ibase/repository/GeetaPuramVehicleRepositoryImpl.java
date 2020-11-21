package webitm.ibase.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webitm.ibase.model.SocietyMember;
import webitm.ibase.utility.HibernateUtility;
import webitm.ibase.utility.ITMException;

@Repository
public class GeetaPuramVehicleRepositoryImpl implements GeetaPuramVehicleRepository
{
	@Autowired
	private SocietyMember societyMember;
	
	
	@Override
	public JSONObject getMemberDataById(int memberId) throws ITMException, SQLException 
	{
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		Query query = null;
		String sql = "";
		List<SocietyMember> list = new ArrayList<SocietyMember>();
		boolean isError = false;
		JSONObject societyMemdata = new JSONObject();
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			sql = "from SocietyMember where memberId=:memId";
			query = session.createQuery(sql);
			query.setParameter("memId", memberId);
			list = query.list();
			
			if(list == null)
			{
				isError = true;
			}
			else
			{
				System.out.println(list);
				list.forEach((societyMember) -> {
					System.out.println(societyMember.getMember_firstName() + "\t" + 
				                       societyMember.getMember_middleName() + "\t" + 
							           societyMember.getMember_lastName());
					
					societyMemdata.put("memFirstName", societyMember.getMember_firstName());
					societyMemdata.put("memMiddleName", societyMember.getMember_middleName());
					societyMemdata.put("memLastName", societyMember.getMember_lastName());
				});
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
			}
		}
		return societyMemdata;
	}

}
