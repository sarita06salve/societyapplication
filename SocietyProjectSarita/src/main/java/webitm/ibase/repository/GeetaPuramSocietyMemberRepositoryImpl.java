package webitm.ibase.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webitm.ibase.model.JointMember;
import webitm.ibase.model.SocietyMember;
import webitm.ibase.model.Vehicle;
import webitm.ibase.utility.HibernateUtility;
import webitm.ibase.utility.ITMException;

@Repository
public class GeetaPuramSocietyMemberRepositoryImpl implements GeetaPuramSocirtyMemberRepository
{
	@Autowired
	private SocietyMember societyMember;
	
	@Autowired
	private JointMember JointMember;
	
	@Autowired
	private Vehicle vehicle;
	
	@Override
	public int saveSocietyMemRecords(SocietyMember societyMember , JointMember jointMember) throws ITMException, SQLException 
	{
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		boolean isError = false;
		int savedata = 0;
		List<JointMember> jointMemberdata = new ArrayList<JointMember>();
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			System.out.println(jointMember.getJointMember_maiden() + "\t" + jointMember.getJointMember_firstName() + "\t" + jointMember.getJointMember_lastName());
			
			String jointFname = jointMember.getJointMember_firstName();
			if(jointFname != null && jointFname.trim().length() > 0)
			{
				jointMember.setJointMemberId(jointMember.getJointMemberId());
				jointMember.setJointMember_maiden(jointMember.getJointMember_maiden());
				jointMember.setJointMember_firstName(jointMember.getJointMember_firstName());
				jointMember.setJointMember_middleName(jointMember.getJointMember_middleName());
				jointMember.setJointMember_lastName(jointMember.getJointMember_lastName());
				jointMember.setJointMember_mobileNo(jointMember.getJointMember_mobileNo());
				jointMemberdata.add(jointMember);
			}
			
			societyMember.setJointMember(jointMemberdata);
			
			session.save(jointMember);
			session.save(societyMember);	
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
					savedata = 0;
					tx.rollback();
					session.flush();
					session.close();
				}
				else
				{
					savedata = 1;
					tx.commit();
					session.flush();
					session.close();
				}
			}
			catch(Exception e)
			{
				savedata = 0;
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Data Saved With Value ::: ["+savedata+"]");
		return savedata;
	}

	@Override
	public List<SocietyMember> getAllData() throws ITMException, SQLException 
	{
		boolean isError = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		String sql = "";
		List<SocietyMember> socMemList = new ArrayList<SocietyMember>();
		try
		{
			sessionFactory = HibernateUtility.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			sql = "from SocietyMember";
			Query query = session.createQuery(sql);
			socMemList = query.list();
			
			if(socMemList == null)
			{
				isError = true;
			}
			else
			{
				System.out.println(socMemList);
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
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		return socMemList;
	}

	@Override
	public SocietyMember getMemberDataById(int memberId) throws ITMException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSocietyMemRecords(SocietyMember societyMember) throws ITMException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
