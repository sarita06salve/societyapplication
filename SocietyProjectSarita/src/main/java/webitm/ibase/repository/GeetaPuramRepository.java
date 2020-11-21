package webitm.ibase.repository;

import webitm.ibase.model.SocietyCommitteeMember;
import webitm.ibase.utility.ITMException;

import java.sql.SQLException;
import java.util.*;

public interface GeetaPuramRepository 
{
	public int saveCommitteeMemRecords(SocietyCommitteeMember committeeMember) throws ITMException;
	public List<SocietyCommitteeMember> getAllData() throws ITMException,SQLException;
	public SocietyCommitteeMember getMemberDataById(int scmId) throws ITMException,SQLException;
	public int updateSocietyMemRecords(SocietyCommitteeMember committeeMember)throws ITMException,SQLException;
}
