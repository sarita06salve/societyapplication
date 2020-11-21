<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
     <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <link href="../css/society.css" rel="stylesheet" type="text/css" />
<title>Update Committee Member Record!!</title>
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
	<c:url var="action" value="/home/updateSocMemData"></c:url>
	<s:form method="post" action="${action}" modelAttribute="committeemember">
	<table align="center" height="100%" width="50%" cellspacing="10px" cellpadding="25px" style="border:5px solid lightblue;background-color: lightblue;margin-top: 10px;">
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
				<s:label path="scmId">Society Committee Member Id </s:label>
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold">
				<s:input path="scmId" readonly="true"/>
			</td>
		</tr>
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
				<s:label path="maiden">Maiden <br/> (Please Select Mr./Mrs./Miss)</s:label>
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold">
			    <s:errors path="maiden"></s:errors>
				<s:input path="maiden"/>
			</td>
		</tr>
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
				<s:label path="scm_firstName">Member First Name </s:label>
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold">
				<s:errors path="scm_firstName"></s:errors>
				<s:input path="scm_firstName"/>
			</td>
		</tr>
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
				<s:label path="scm_middleName">Member Middle Name </s:label>
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold">
				<s:errors path="scm_middleName"></s:errors>
				<s:input path="scm_middleName"/>
			</td>
		</tr>
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
				<s:label path="scm_lastName">Member Last Name </s:label>
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold">
				<s:errors path="scm_lastName"></s:errors>
				<s:input path="scm_lastName"/>
			</td>
		</tr>
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
				<s:label path="scm_mobileNo">Mobile No </s:label>
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold">
				<s:errors path="scm_mobileNo"></s:errors>
				<s:input path="scm_mobileNo"/>
			</td>
		</tr>
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
				<s:label path="scm_designation">Designation </s:label>
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold">
				<s:input path="scm_designation" readonly="true"/>
			</td>
		</tr>
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
				<input type="submit" value="Update" />
			</td>
		</tr>
	</table>
	</s:form>
</body>
</html>