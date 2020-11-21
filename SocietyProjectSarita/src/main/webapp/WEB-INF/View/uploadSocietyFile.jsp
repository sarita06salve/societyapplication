<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload File Page</title>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
    <link href="../css/society.css" rel="stylesheet" type="text/css" />
    <c:url var="action"  value="/home/uploadselectfile"></c:url>
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

	<s:form action="${action}" method="post" enctype="multipart/form-data">
	 <table align="center" height="100%" width="50%" cellspacing="10px" cellpadding="25px" style="border:5px solid lightblue;background-color: lightblue;margin-top: 10px;">
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				Upload File 
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
		 		<input type="file" name ="noticefile" id = "noticefile" required="required" />
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<input type="submit" value="Upload File" />
			</td>
		</tr>
	</table>
	</s:form>
</body>
</html>