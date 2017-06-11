<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Register Page</title>
</head>
<body>
	<form action="${ pageContext.request.contextPath }/RegistServlet" method="post">
		<table width="600px" border="1px solid #F00">
			<tr>
				<td>username</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>nickname</td>
				<td><input type="text" name="nickname" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="register" /></td>
			</tr>
		</table>
	</form>
</body>
</html>