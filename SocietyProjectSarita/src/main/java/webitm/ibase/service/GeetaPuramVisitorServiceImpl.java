package webitm.ibase.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webitm.ibase.model.IncomeVoucher;
import webitm.ibase.model.Visitors;
import webitm.ibase.repository.GeetaPuramVisitorRepository;
import webitm.ibase.repository.GeetaPuramVoucherRepository;
import webitm.ibase.utility.ITMException;

@Service
public class GeetaPuramVisitorServiceImpl implements GeetaPuramVisitorService
{

	@Autowired
	private GeetaPuramVisitorRepository geetaPuramVisitorRepository;
	
	@Override
	public int saveVisitorRecords(Visitors visitors) throws ITMException,SQLException
	{
		int saveData = 0;
		try
		{
			saveData = geetaPuramVisitorRepository.saveVisitorRecords(visitors);
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
	public List<Visitors> getAllVisitorData() throws ITMException, SQLException 
	{
		List<Visitors> visitorList = new ArrayList<Visitors>();
		try
		{
			visitorList = geetaPuramVisitorRepository.getAllVisitorData();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return visitorList;
	}

}
