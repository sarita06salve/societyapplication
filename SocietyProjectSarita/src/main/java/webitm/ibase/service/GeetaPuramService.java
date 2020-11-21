package webitm.ibase.service;

import java.sql.SQLException;
import java.util.List;

import webitm.ibase.model.SocietyCommitteeMember;
import webitm.ibase.utility.ITMException;

public interface GeetaPuramService 
{
	public int saveCommitteeMemberRecord(SocietyCommitteeMember committeeMember) throws ITMException;
	public List<SocietyCommitteeMember> getAllData() throws ITMException,SQLException;
	public SocietyCommitteeMember getMemberDataById(int scmId) throws ITMException,SQLException;
	public int updateSocietyMemRecords(SocietyCommitteeMember committeeMember)throws ITMException,SQLException;
}
