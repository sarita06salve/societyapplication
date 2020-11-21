<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Society Member Data</title>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link href="../css/society.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/input.js"></script>
</head>
<body onload="onloadHideTable();">
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
	
	<c:url var="action" value="/home/saveMember"></c:url>
	<form:form action="${action}" method="post" modelAttribute="societymembermodel">
		<table align="center" height="100%" width="50%" cellspacing="10px" cellpadding="25px" style="border:5px solid lightblue;background-color: lightblue;margin-top: 10px;">
			<tr>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
					<form:label path="memberId">Society Member Id </form:label>	
				</td>
				<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 		<form:input path="memberId" id="memberId" disabled="true" size="10" maxlength="30"/>
				</td>
			</tr>
		
			<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Maiden <br/> (Please Select Mr./Mrs./Miss) 
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<form:select path="maiden">
			 		<form:option value="Mr." label="Mr."></form:option>
			 		<form:option value="Mrs." label="Mrs."></form:option>
			 		<form:option value="Miss" label="Miss"></form:option>
			 	</form:select>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				 Member First Name 	
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			    <form:errors path="member_firstName"></form:errors>
			 	<form:input path="member_firstName" id="member_firstName" size="20"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Member Middle Name 
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			 	<form:errors path="member_middleName"></form:errors>
			 	<form:input path="member_middleName" id="member_middleName" size="20"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Member Last Name  	
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			 	<form:errors path="member_lastName"></form:errors>
			 	<form:input path="member_lastName"  id="member_lastName"  size="20"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Building Name 
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<form:select path="member_bldgName">
			 		<form:option value="A" label="A"></form:option>
			 		<form:option value="B" label="B"></form:option>
			 	</form:select>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Building No 
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<form:select path="member_bldgNo">
			 		<form:option value="1" label="1"></form:option>
			 		<form:option value="2" label="2"></form:option>
			 	</form:select>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Building No 
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<form:select path="member_blockNo">
			 		<form:option value="001" label="001"></form:option>
			 		<form:option value="002" label="002"></form:option>
			 		<form:option value="003" label="003"></form:option>
			 		<form:option value="004" label="004"></form:option>
			 		<form:option value="101" label="101"></form:option>
			 		<form:option value="102" label="102"></form:option>
			 		<form:option value="103" label="103"></form:option>
			 		<form:option value="104" label="104"></form:option>
			 		<form:option value="201" label="201"></form:option>
			 		<form:option value="202" label="202"></form:option>
			 		<form:option value="203" label="203"></form:option>
			 		<form:option value="204" label="204"></form:option>
			 		<form:option value="301" label="301"></form:option>
			 		<form:option value="302" label="302"></form:option>
			 		<form:option value="303" label="303"></form:option>
			 		<form:option value="304" label="304"></form:option>
			 		<form:option value="401" label="401"></form:option>
			 		<form:option value="402" label="402"></form:option>
			 		<form:option value="403" label="403"></form:option>
			 		<form:option value="404" label="404"></form:option>
			 	</form:select>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Mobile No
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			 	<form:errors path="member_mobileNo"></form:errors>
			 	<form:input path="member_mobileNo"  id="member_mobileNo"  size="20"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Has Joint Member?
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<form:select path="member_isJoint" onchange="showAndHideJointMemTable();">
			 		<form:option value="NO" label="NO"></form:option>
			 		<form:option value="YES" label="YES"></form:option>
			 	</form:select>
			</td>
		</tr>
		
		<tr id="joinmemtable">
			<td>
				<form:form method="post" modelAttribute="jointmembermodel">
					<table  align="center" height="100%" width="50%" cellspacing="10px" cellpadding="25px" style="border:5px solid lightblue;background-color: lightblue;margin-top: 10px;">
						<tr>
							<th style="border: 1px solid black">Select</th>
							<th style="border: 1px solid black">Sr. No.</th>
							<th style="border: 1px solid black">Joint Member<br/> Maiden</th>
							<th style="border: 1px solid black">Joint Member<br/> First Name</th>
							<th style="border: 1px solid black">Joint Member<br/> Middle Name</th>
							<th style="border: 1px solid black">Joint Member<br/> Last Name</th>
							<th style="border: 1px solid black">Joint Member Mobile No</th>
						</tr>
						<%
							for(int i = 1; i<=1; i++)
							{
						%>
						<tr>
							<td style="border: 1px solid black">
			 				  <input type="checkbox" id="joinmemcheck" onclick="joinmemFormValidate()"/>
							</td>
							
							<td style="border: 1px solid black">
								<!--<form:input path="jointMemberId" id="jointMemberId" disabled="true" size="10" maxlength="20"/>-->
								<input type="text" id="jointMemberId" hidden="true">
			 				   <%=i %>
							</td>
							
							<td style="border: 1px solid black">
			 					<form:select path="jointMember_maiden">
			 						<form:option value="Mr." label="Mr."></form:option>
			 						<form:option value="Mrs." label="Mrs."></form:option>
			 						<form:option value="Miss" label="Miss"></form:option>
			 					</form:select>
							</td>
							
							<td style="border: 1px solid black;color: red">
								<form:errors path="jointMember_firstName"></form:errors>
			 					<form:input path="jointMember_firstName" id="jointMember_firstName" size="10"/>
							</td>
							
							<td style="border: 1px solid black;color: red">
							    <form:errors path="jointMember_middleName"></form:errors>
			 					<form:input path="jointMember_middleName" id="jointMember_middleName" size="10"/>
							</td>
							
							<td style="border: 1px solid black;color: red">
							    <form:errors path="jointMember_middleName"></form:errors>
			 					<form:input path="jointMember_lastName" id="jointMember_lastName" size="10"/>
							</td>
							
							<td style="border: 1px solid black;color: red">
								<form:errors path="jointMember_middleName"></form:errors>
			 					<form:input path="jointMember_mobileNo" id="jointMember_mobileNo" size="5"/>
							</td>
						</tr>	
						<%
							}
						%>	
					</table>
				</form:form>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Alternate Mobile No
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			 	<form:errors path="member_altMobileNo"></form:errors>
			 	<form:input path="member_altMobileNo"  id="member_altMobileNo"  size="20"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Member Registration No
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			 	<form:errors path="member_registrationNo"></form:errors>
			 	<form:input path="member_registrationNo"  id="member_registrationNo"  size="20"/>
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