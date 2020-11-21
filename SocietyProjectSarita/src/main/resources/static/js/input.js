function setDefaultValues()
{
	alert("I am getting called!!");
	document.getElementById("scmId").innerHTML = "";
	document.getElementById("scm_firstName").innerHTML = "";
	document.getElementById("scm_middleName").innerHTML = "";
	document.getElementById("scm_lastName").innerHTML = "";
}

function showAndHideJointMemTable()
{
	var isJointMem = document.getElementById("member_isJoint").value;
	if("YES" == isJointMem)
	{
		 document.getElementById("joinmemtable").style.display="";
	}
	else
	{
		document.getElementById("joinmemtable").style.display="none";
	}
}

function joinmemFormValidate()
{
    alert("123456789");
    var testCheckbox = document.getElementById("joinmemcheck"); 
    var memFirstName = document.getElementById("jointMember_firstName").value;
    var memMiddName = document.getElementById("jointMember_middleName").value;
    var melLastName = document.getElementById("jointMember_lastName").value;
    var memMobNo = document.getElementById("jointMember_mobileNo").value;
    if(testCheckbox.checked)
    {
		alert("123" + memFirstName.trim() + "456" + memMiddName.trim() + "789" + melLastName.trim() + "112" + memMobNo.trim() + "113");
		if(memFirstName.trim() == "")
		{	
			alert("Member First Name can't be Empty!!!");
			document.getElementById("joinmemcheck").checked = false;
		}
		if(memMiddName.trim() == "")
		{
			alert("Member Middle Name can't be Empty!!!");
			document.getElementById("joinmemcheck").checked = false;
		}
		if(melLastName.trim() == "")
		{
			alert("Member Last Name can't be Empty!!!");
			document.getElementById("joinmemcheck").checked = false;
		}
		if(memMobNo.trim() == "")
		{	
			alert("Member's Mobile No can't be Empty!!!");
			document.getElementById("joinmemcheck").checked = false;
		}
    }
 }	
 
 
 function vehicleFormValidate()
{
	alert("Sar12345");
    var testCheckbox = document.getElementById("joinVehCheck"); 
    var vehicleNo = document.getElementById("vehicleNo").value;
    if(testCheckbox.checked)
    {
		alert("123" + vehicleNo.trim());
		if(vehicleNo.trim() == "")
		{	
			alert("Vehicle No can't be Empty!!!");
			document.getElementById("joinVehCheck").checked = false;
		}
    } 
 }	
 
 function onloadHideTable()
{
	//document.getElementById("joinmemtable").style.display="none";
	//document.getElementById("vehicletable").style.display="none";
	
	var isJointMem = document.getElementById("member_isJoint").value;
	if("YES" == isJointMem)
	{
		 document.getElementById("joinmemtable").style.display="";
	}
	else
	{
		document.getElementById("joinmemtable").style.display="none";
	}
}



function getMemberId()
{	
	var memberId = document.getElementById("memberId").value;
	alert("Hi... Welcome..." + memberId);
	
	var url = "/home/getMemDataById/"+ memberId;
	alert(url);
	
	if(window.XMLHttpRequest)
	{	
		request = new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
	{
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	try
	{
		request.onreadystatechange = getInformation;
		request.open("GET",url,true);
		request.send();
	}
	catch(e)
	{
		alert("Unable to connect server..");
	}
}

function getInformation()
{
	if(request.readyState == 4)
	{
		alert("1122334455" + request.responseXML);
		var val = JSON.parse(request.responseText);
		//alert("Hi...eeee..." + val);
		document.getElementById("member_firstName").value = val.memFirstName;
		document.getElementById("member_middleName").value = val.memMiddleName;
		document.getElementById("member_lastName").value = val.memLastName;
	}
}