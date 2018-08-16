<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Withdraw</h1>
<h3>Enter the Details:</h3>
<form action="saveWithdraw.mmb">
<table>
<tr>
<td>Account Number</td>
<td><input type="number" name="accno"></td>
</tr>
<tr>
<td>Amount</td>
<td><input type="number" name="amount"></td>
</tr>
<tr>
<td><input type="submit" value="Withdraw">
</table>
</form>
</body>
</html>