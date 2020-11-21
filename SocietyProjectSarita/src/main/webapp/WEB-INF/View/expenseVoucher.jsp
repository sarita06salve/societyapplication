<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../css/society.css" rel="stylesheet" type="text/css" />
<c:url var="action" value="/home/addExpVoucher"></c:url>
<title>Expense Voucher</title>
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

	<s:form action="${action}" method="post" modelAttribute="addExpVoucher">
	<table align="center" height="100%" width="50%" cellspacing="10px" cellpadding="25px" style="border:5px solid lightblue;background-color: lightblue;margin-top: 10px;">
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="expVouchId">Expense Voucher Id </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:input path="expVouchId" id="expVouchId" readonly="true" size="30" maxlength="10" />
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="expVouchDate">Expense Voucher Date </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:input path="expVouchDate" id="expVouchDate" size="30"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="expVouchType">Voucher Type </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:select path="expVouchType">
			 		<s:option value="Electricity Bill" label="Electricity Bill"></s:option>
			 		<s:option value="Water Use Bill" label="Water Use Bill"></s:option>
			 		<s:option value="Staff Salary" label="Staff Salary"></s:option>
			 		<s:option value="Society Maintenance" label="Society Maintenance"></s:option>
			 		<s:option value="Others" label="Others"></s:option>
			 	</s:select>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="expVouchDescription">Description </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:textarea path="expVouchDescription" id="expVouchDescription" size="30" maxlength="300"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="expVouchAmount">Voucher Amount </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:input path="expVouchAmount" id="expVouchAmount" size="30" maxlength="20"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="expVouchAmtRs">Voucher Amount <br/> (In Rupees..) </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:textarea path="expVouchAmtRs" id="expVouchAmtRs" size="30" maxlength="150"/>
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