<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="jstl" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Name</th>
<th>Account Balance after withdrawal</th>
</tr>
<tr>
<td>${bal.accountHolder.customerName}</td>
</tr>
</table>
</body>
</html>