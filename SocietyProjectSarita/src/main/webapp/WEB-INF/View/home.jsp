<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Home Page</title>
</head>
<body>
	<c:url var="action" value="/home/login"></c:url>

	<table height="100%" width="100%" style="background-color:lightblue;border: 5px solid blue;">
	<tr>
		<td height="100%" width="80%">
			<img src="images/society.jpg" width="100%" height="50%">
		</td>
		
		<td valign="top">
		    <div style="text-align: center;font-weight: bold;font-size: 50px;color: brown;">
		    	Welcome <br/> To <br/> GEETA <br/> PURAM <br/> SOCIETY <br/> Pvt. Ltd.,
		    </div>
		    <div style="margin-top: 50px">
		    	<img src="images/admin.jpg" width="100%" height="100%">
		    </div>
		    <div style="margin-top: 25px">
		    <h4 style="color: red;">${error}</h4>
		    <form action="${action}" method="post">
		    	<table height="100%" weight="100%" cellspacing="5px" cellpadding="5px" border=1px solid black>
		    		<tr>
		    			<td>
		    				Username
		    			</td>
		    			<td>
		    				<input type="text" name="username" size="24px" placeholder="Username Here.."/>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>
		    				Password
		    			</td>
		    			<td>
		    				<input type="password" name="password" size="24px" placeholder="Password Here.."/>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>
		    				<input type="submit" value="Login">
		    			</td>
		    		</tr>
		    	</table>
		    </div>
		</form>
		</td>
	</tr>
	</table>
</body>
</html>