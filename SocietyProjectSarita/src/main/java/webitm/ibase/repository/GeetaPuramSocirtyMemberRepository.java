package webitm.ibase.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import webitm.ibase.model.JointMember;
import webitm.ibase.model.SocietyCommitteeMember;
import webitm.ibase.model.SocietyMember;
import webitm.ibase.model.Vehicle;
import webitm.ibase.model.Visitors;
import webitm.ibase.utility.ITMException;


public interface GeetaPuramSocirtyMemberRepository 
{
	public int saveSocietyMemRecords(SocietyMember societyMember , JointMember jointMember) throws ITMException, SQLException;
	public List<SocietyMember> getAllData() throws ITMException,SQLException;
	public SocietyMember getMemberDataById(int memberId) throws ITMException,SQLException;
	public int updateSocietyMemRecords(SocietyMember societyMember)throws ITMException,SQLException;
}
