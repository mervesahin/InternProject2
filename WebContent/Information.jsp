<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="PersonInformation" action="NewServlet" method="post">
		<table style="width: 500px">
			<tr>
				<td>Ad :</td>
				<td><input name="ad" type="text"></td>
			</tr>
			<tr>
				<td>Soyad :</td>
				<td><input name="soyad" type="text"></td>
			</tr>
			<tr>
				<td>Sehir :</td>
				<td><input name="sehir" type="text"></td>
			</tr>
			<tr>
				<td>Sifre :</td>
				<td><input name="sifre" type="text"></td>
			</tr>
		</table>
		<input type="submit" value="Kaydol" name="submit" > <input type="submit"
			value="Sil" name="submit" > <input type="submit" value="Guncelle" name="submit" > 

	</form>
</body>
</html>