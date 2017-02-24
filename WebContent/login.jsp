<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="PersonLogin" action="j_security_check" method="post">
		<table style="width: 500px">
			<tr>
				<td>Username :</td>
				<td><input name="j_username" type="text"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input name="j_password" type="text"></td>
			</tr>
		</table>
		<input type="submit" value="Login" name="submit" > 
	</form>
</body>
</html>