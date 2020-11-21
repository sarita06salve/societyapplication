package webitm.ibase.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import webitm.ibase.model.SocietyCommitteeMember;
import webitm.ibase.model.Visitors;
import webitm.ibase.utility.ITMException;

public interface GeetaPuramVisitorRepository 
{
	public int saveVisitorRecords(Visitors visitors) throws ITMException,SQLException;
	public List<Visitors> getAllVisitorData() throws ITMException,SQLException;
}
