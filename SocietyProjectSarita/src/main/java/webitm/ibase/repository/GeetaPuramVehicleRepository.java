package webitm.ibase.repository;

import java.sql.SQLException;

import org.json.JSONObject;

import webitm.ibase.utility.ITMException;

public interface GeetaPuramVehicleRepository 
{
	public JSONObject getMemberDataById(int memberId) throws ITMException,SQLException;
}
