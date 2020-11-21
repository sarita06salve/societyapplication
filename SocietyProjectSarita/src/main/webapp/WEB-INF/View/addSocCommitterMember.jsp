<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../css/society.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="input1.js"></script>
<title>Add Society Committee Member Data</title>
</head>
<c:url var="action" value="/home/saveComMember"></c:url>
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
	
 <s:form action="${action}" method="post" modelAttribute="saveComMember">
	<table align="center" height="100%" width="50%" cellspacing="10px" cellpadding="25px" style="border:5px solid lightblue;background-color: lightblue;margin-top: 10px;">
		 <tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="scmId">Society Committee Member Id </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:input path="scmId" id="scmId" disabled="true" size="30" maxlength="30"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Maiden <br/> (Please Select Mr./Mrs./Miss) 
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:select path="maiden">
			 		<s:option value="Mr." label="Mr."></s:option>
			 		<s:option value="Mrs." label="Mrs."></s:option>
			 		<s:option value="Miss" label="Miss"></s:option>
			 	</s:select>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				 Member First Name 	
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			    <s:errors path="scm_firstName"></s:errors>
			 	<s:input path="scm_firstName" id="scm_firstName" size="30"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Member Middle Name 
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			 	<s:errors path="scm_middleName"></s:errors>
			 	<s:input path="scm_middleName" id="scm_middleName" size="30"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Member Last Name  	
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			 	<s:errors path="scm_lastName"></s:errors>
			 	<s:input path="scm_lastName"  id="scm_lastName"  size="30"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Mobile No  	
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			    <s:errors path="scm_mobileNo"></s:errors>
			 	<s:input path="scm_mobileNo" id="scm_mobileNo" size="30" maxlength="10"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Designation 	
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:select path="scm_designation" >
			 		<s:option value="President" label="President"></s:option>
			 		<s:option value="Vice-President" label="Vice-President"></s:option>
			 		<s:option value="Secretary" label="Secretary"></s:option>
			 		<s:option value="Joint-Secretary" label="Joint-Secretary"></s:option>
			 		<s:option value="Treasurer" label="Treasurer"></s:option>
			 		<s:option value="Member" label="Member"></s:option>
			 	</s:select>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<input type="submit" value="Save">
			</td>
		</tr>
	</table>
	</s:form>
</body>
</html>