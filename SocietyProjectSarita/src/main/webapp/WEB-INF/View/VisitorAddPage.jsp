<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 	<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
 	<link href="../css/society.css" rel="stylesheet" type="text/css" />
 	 <c:url var="action" value="/home/addVisitorInfo"></c:url>
	<title>Add Visitor Information</title>
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
   
	<s:form action="${action}" method="post" modelAttribute="addVisitorInfo">
		<table align="center" height="100%" width="50%" cellspacing="10px" cellpadding="25px" style="border:5px solid lightblue;background-color: lightblue;margin-top: 10px;">
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
					<s:label path="visitorId">Visitor ID </s:label>	
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 		<s:input path="visitorId" id="visitorId" readonly="true" size="30" maxlength="30"/>
				</td>
			</tr>
			
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
					<s:label path="visitDate">Visit Date</s:label>	
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 		<s:input path="visitDate" id="visitDate" size="30"/>
				</td>
			</tr>
			
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
					<s:label path="vistiotorName">Visitor's Name </s:label>	
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 		<s:input path="vistiotorName" id="vistiotorName" size="90" maxlength="50"/>
				</td>
			</tr>
			
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
					<s:label path="idProofType">Visitor's Valid ID Proof </s:label>	
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 		<s:select path="idProofType" id="idProofType">
			 		<s:option value="OFFICE ID" label="OFFICE ID"></s:option>
			 		<s:option value="PANCARD NO" label="PANCARD NO"></s:option>
			 		<s:option value="AADHAR CARD NO" label="AADHAR CARD NO"></s:option>
			 		<s:option value="DRIVING LICENSE NO" label="DRIVING LICENSE NO"></s:option>
			 		<s:option value="VOTING CARD NO" label="VOTING CARD NO"></s:option>
			 	</s:select>
				</td>
			</tr>
			
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
					<s:label path="proofNumber">ID Proof Number </s:label>	
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 		<s:input path="proofNumber" id="proofNumber" size="30" maxlength="30"/>
				</td>
			</tr>
			
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
					<s:label path="inTime">In Time (hh:mm) </s:label>	
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 		<s:input path="inTime" id="inTime" size="30" />
				</td>
			</tr>
			
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
					<s:label path="outTime">Out Time (hh:mm)</s:label>	
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 		<s:input path="outTime" id="outTime" size="30"/>
				</td>
			</tr>
			<tr>
		    	<td>
		  			<input type="submit" value="SAVE">
				</td>
		   	</tr>
		</table>
	</s:form>
</body>
</html>