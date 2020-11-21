<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="input1.js"></script>
<link href="../css/society.css" rel="stylesheet" type="text/css" />
<c:url var="action" value="/home/addIncVoucher"></c:url>
<title>Income Voucher</title>
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
	
	<s:form action="${action}" method="post" modelAttribute="addIncVoucher">
	<table align="center" height="100%" width="50%" cellspacing="10px" cellpadding="25px" style="border:5px solid lightblue;background-color: lightblue;margin-top: 10px;">
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="incVouchId">Income Voucher Id </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:input path="incVouchId" id="incVouchId" readonly="true" size="30" maxlength="10" />
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="incVouchDate">Income Voucher Date </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:input path="incVouchDate" id="incVouchDate" size="30"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="incVouchType">Voucher Type </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">
			 	<s:select path="incVouchType">
			 		<s:option value="Maintainance" label="Maintainance"></s:option>
			 		<s:option value="Society Maint. Fund" label="Society Maint. Fund"></s:option>
			 		<s:option value="Others" label="Others"></s:option>
			 	</s:select>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="incVouchDescription">Description </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
				<s:errors path="incVouchDescription"></s:errors>
			 	<s:textarea path="incVouchDescription" id="incVouchDescription" size="30" maxlength="300"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="incVouchAmount">Voucher Amount </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			 	<s:input path="incVouchAmount" id="incVouchAmount" size="30"/>
			</td>
		</tr>
		
		<tr>
			<td style="border: 2px solid brown;font-size: 18px;font-weight: bold">	
				<s:label path="incVouchAmtRs">Voucher Amount <br/> (In Rupees..) </s:label>	
			</td>
			<td style="border: 2px solid brown;font-size: 15px;font-weight: bold;color: red">
			     <s:errors path="incVouchAmtRs"></s:errors>
			 	<s:textarea path="incVouchAmtRs" id="incVouchAmtRs" size="30" maxlength="150"/>
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