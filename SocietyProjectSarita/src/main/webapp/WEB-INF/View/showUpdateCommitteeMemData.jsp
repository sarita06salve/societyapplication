<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
 <link href="../css/society.css" rel="stylesheet" type="text/css" />
<title>Sociery Committee Member List</title>
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
	<table align="center" height="100%" width="50%" cellspacing="10px" cellpadding="25px" style="border:5px solid lightblue;background-color: lightblue;margin-top: 10px;">
		<tr>
			<th style="border: 1px solid black">Committee <br/>  Member <br/> ID</th>
			<th style="border: 1px solid black">Maiden <br/> Name</th>
			<th style="border: 1px solid black">Member <br/> First Name</th>
			<th style="border: 1px solid black">Member <br/> Middle Name</th>
			<th style="border: 1px solid black">Member <br/> Last Name</th>
			<th style="border: 1px solid black">Member <br/> Contact No</th>
			<th style="border: 1px solid black">Designation</th>
			<th style="border: 1px solid black">Update Record</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
		<tr>
			<td style="border: 1px solid black">
				<c:out value="${member.scmId}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${member.maiden}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${member.scm_firstName}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${member.scm_middleName}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${member.scm_lastName}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${member.scm_mobileNo}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${member.scm_designation}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<a href='<c:url value="/home/getMemberDataById/${member.scmId}"></c:url>'>Update</a>
			</td>
		</tr>
		</c:forEach>
		
</table>	
</body>
</html>