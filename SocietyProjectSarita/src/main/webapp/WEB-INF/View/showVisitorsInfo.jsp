<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
 <link href="../css/society.css" rel="stylesheet" type="text/css" />
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
			<th style="border: 1px solid black">Visitor ID</th>
			<th style="border: 1px solid black">Visit Date</th>
			<th style="border: 1px solid black">Visitor's Name</th>
			<th style="border: 1px solid black">Visitor's Valid ID Proof</th>
			<th style="border: 1px solid black">ID Proof Number</th>
			<th style="border: 1px solid black">In Time (hh:mm)</th>
			<th style="border: 1px solid black">Out Time (hh:mm)</th>
		</tr>
		<c:forEach var="visitor" items="${visitorList}">
		<tr>
			<td style="border: 1px solid black">
				<c:out value="${visitor.visitorId}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${visitor.visitDate}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${visitor.vistiotorName}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${visitor.idProofType}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${visitor.proofNumber}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${visitor.inTime}"></c:out>
			</td>
			<td style="border: 1px solid black">
				<c:out value="${visitor.outTime}"></c:out>
			</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>