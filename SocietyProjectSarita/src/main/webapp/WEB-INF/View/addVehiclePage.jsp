<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Adding Vehicle Information..</title>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link href="../css/society.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/input.js"></script>
</head>
<body>
	<table align="center" height="100%" width="100%">
		<tr>
			<td align="left" width="20%">
				<a style="color: white" href="/home/loginPage"> PREVIOUS </a>
			</td>
			<td align="center" width="80%">
				 <h2 style="color: white;font-size: 30px;font-weight:bold"> GEETA PURAM SOCIETY PVT. LTD., </h2>
			</td>
			<td align="right" width="30%">
				<a style="color: white" href="../home"> LOGOUT </a>
			</td>
		</tr>
	</table>
	
	<c:url var="action" value="/home/saveVehicle"></c:url>
	<form:form action="${action}" method="post" modelAttribute="vehicleInfo">
		<table align="center" height="100%" width="50%" cellspacing="10px" cellpadding="25px" style="border:5px solid lightblue;background-color: lightblue;margin-top: 2px;">
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold; width: 60px">	
					<form:label path="vehicleId">Vehicle Id </form:label>	
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 		<form:input path="vehicleId" id="vehicleId" disabled="true" size="10" maxlength="30"/>
				</td>
			</tr>
			
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
					Vehicle Type <br/> (Please Select) 
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 		<form:select path="typeOfVehicle">
			 			<form:option value="CAR" label="CAR"></form:option>
			 			<form:option value="BIKE" label="BIKE"></form:option>
			 			<form:option value="RICKSHAW" label="RICKSHAW"></form:option>
			 			<form:option value="MINI BUS" label="MINI BUS"></form:option>
			 			<form:option value="TRUCK" label="TRUCK"></form:option>
			 			<form:option value="TEMPO" label="TEMPO"></form:option>
			 		</form:select>
				</td>
			</tr>
			
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
					<form:label path="noOfVehicle">No. Of Vehicle </form:label>	
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 		<form:select path="noOfVehicle">
			 			<form:option value="1" label="1"></form:option>
			 		</form:select>
				</td>
			</tr>
			
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
					<form:label path="vehicleNo">Vehicle Number</form:label>	
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold;color:red">
					<form:errors path="vehicleNo"></form:errors>
			 		<form:input path="vehicleNo" id="vehicleNo" size="10" maxlength="30"/>
				</td>
			</tr>
			
			<tr>
			<td>
				<form:form method="post" modelAttribute="memberInfo">
				<table align="center" height="100%" width="50%" cellspacing="10px" cellpadding="25px" style="border:5px solid lightblue;background-color: lightblue;margin-top: 2px;">
				<tr>
					<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
						<form:label path="memberId">Society Member Id</form:label>	
					</td>
					<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 			<form:input path="memberId" id="memberId" size="5" maxlength="10" onchange="getMemberId();"/>
					</td>
				</tr>
			
				<tr>
					<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
						<form:label path="member_firstName">Member First Name</form:label>	
					</td>
					<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 			<form:input path="member_firstName" id="member_firstName" disabled="true" size="10" maxlength="30"/>
					</td>
				</tr>
			
				<tr>
					<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
						<form:label path="member_middleName">Member Middle Name</form:label>	
					</td>
					<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 			<form:input path="member_middleName" id="member_middleName" disabled="true" size="10" maxlength="30"/>
					</td>
				</tr>
			
				<tr>
					<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
						<form:label path="member_lastName">Member Last Name</form:label>	
					</td>
					<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 			<form:input path="member_lastName" id="member_lastName" disabled="true" size="10" maxlength="30"/>
					</td>
				</tr>
				</table>
				</form:form>
			</td>
			</tr>
			
			<tr>
			<td>
				<input type="submit" value="SAVE DATA" />
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>