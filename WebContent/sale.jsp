<%@page import="org.omg.PortableServer.ForwardRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<html>
<head>
<style type="text/css">
.head {
	font-size: 30px;
	color: #C71585;
}

body {
	background-color: #ffe4b5;
}

td { //
	background-color: #e3e3e3; //
	size: 50;
	style ="width: 77%;
	height: 80%; "
	text-align: center;
}
</style>
<script language="javascript" type="text/javascript" src="load.js"></script>

</head>
<body body background="ab.jpg">
	<div class="menu">

		<div class="head" align="center"></div>


		<form id="formname" name="formname" action="SaleControler"
			onSubmit="return validateForm()" method="post"
			enctype="multipart/form-data">
			<table width="130" height="100" border="7" align="center">
				<tr>
					<td><input type="file" name="image"
						onChange="previewImage(this)" accept="image/*" required="required" /></td>

					<td width="21%" height="150" align="right" valign="middle"><div
							align="center">
							<img name="preview" width="170" height="100" id="preview"
								alt="upload photo" />
						</div>
				</tr>
				<tr>
					<td colspan="2" width="31%" align="center" valign=""><input
						name="submit" type="submit" value="Submit"></td>
				</tr>
			</table>

		</form>
</body>
</html>

