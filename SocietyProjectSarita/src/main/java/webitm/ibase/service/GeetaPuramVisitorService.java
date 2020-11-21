package webitm.ibase.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import webitm.ibase.model.Visitors;
import webitm.ibase.utility.ITMException;


public interface GeetaPuramVisitorService 
{
	public int saveVisitorRecords(Visitors visitors) throws ITMException,SQLException;
	public List<Visitors> getAllVisitorData() throws ITMException,SQLException;
}
