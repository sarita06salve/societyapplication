package webitm.ibase.service;

import java.sql.SQLException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webitm.ibase.repository.GeetaPuramVehicleRepository;
import webitm.ibase.utility.ITMException;

@Service
public class GeetaPuramVehicleServiceImpl implements GeetaPuramVehicleService
{
	@Autowired
	private GeetaPuramVehicleRepository geetaPuramVehicleRepository;

	@Override
	public JSONObject getMemberDataById(int memberId) throws ITMException, SQLException 
	{
		JSONObject societyMemdata = new JSONObject();
		try
		{
			societyMemdata = geetaPuramVehicleRepository.getMemberDataById(memberId);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return societyMemdata;
	}
}
