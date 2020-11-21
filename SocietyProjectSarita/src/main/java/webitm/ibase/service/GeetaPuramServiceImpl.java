package webitm.ibase.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webitm.ibase.model.SocietyCommitteeMember;
import webitm.ibase.repository.GeetaPuramRepository;
import webitm.ibase.utility.ITMException;

@Service
public class GeetaPuramServiceImpl implements GeetaPuramService
{
	@Autowired
	private GeetaPuramRepository geetaPuramRepository; 
	
	
	public int saveCommitteeMemberRecord(SocietyCommitteeMember committeeMember) throws ITMException
	{
		int saveData = 0;
		try
		{
			saveData = geetaPuramRepository.saveCommitteeMemRecords(committeeMember);
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
	public List<SocietyCommitteeMember> getAllData()
			throws ITMException, SQLException 
	{
		List<SocietyCommitteeMember> memberList = new ArrayList<SocietyCommitteeMember>();
		try
		{
			memberList = geetaPuramRepository.getAllData();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return memberList;
	}


	@Override
	public int updateSocietyMemRecords(SocietyCommitteeMember committeeMember) throws ITMException, SQLException 
	{
		int updateData = 0;
		try
		{
			updateData = geetaPuramRepository.updateSocietyMemRecords(committeeMember);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return updateData;
	}


	@Override
	public SocietyCommitteeMember getMemberDataById(int scmId) throws ITMException,SQLException
	{
		SocietyCommitteeMember committeeMember = null;
		try
		{
			committeeMember = geetaPuramRepository.getMemberDataById(scmId);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return committeeMember;
	}
}
