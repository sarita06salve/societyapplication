package webitm.ibase.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import webitm.ibase.model.JointMember;
import webitm.ibase.model.SocietyMember;
import webitm.ibase.model.Vehicle;
import webitm.ibase.repository.GeetaPuramRepository;
import webitm.ibase.repository.GeetaPuramSocirtyMemberRepository;
import webitm.ibase.utility.ITMException;

@Repository
public class GeetaPuramSocietyMemberServiceImpl implements GeetaPuramSocietyMemberService
{
	@Autowired
	private GeetaPuramSocirtyMemberRepository geetaPuramSocirtyMemberRepository; 
	
	@Override
	public int saveSocietyMemRecords(SocietyMember societyMember , JointMember jointMember) throws ITMException, SQLException
	{
		int saveData = 0;
		try
		{
			saveData = geetaPuramSocirtyMemberRepository.saveSocietyMemRecords(societyMember, jointMember);
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
	public List<SocietyMember> getAllData() throws ITMException, SQLException 
	{
		List<SocietyMember> socMemList = new ArrayList<SocietyMember>();
		try
		{
			socMemList = geetaPuramSocirtyMemberRepository.getAllData();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
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
