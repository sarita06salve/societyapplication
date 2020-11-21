package webitm.ibase.service;

import java.sql.SQLException;

import org.json.JSONObject;

import webitm.ibase.utility.ITMException;

public interface GeetaPuramVehicleService 
{
	public JSONObject getMemberDataById(int memberId) throws ITMException,SQLException;

}
