<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="checkBal">
<label>User ID</label><input type="text" name="userId"><br>
<label>Mobile Number</label><input type="text" name="mobileNo"><br>
<label>Amount</label><input type="number" min="10" name="amount"><br>

<label>Operator</label> <select name="operator"><br>
        <option value="Jio">Jio</option>
        <option value="Vodafone">Vodafone</option>
        <option value="Airtel">Airtel</option>     
      </select><br>
<input type="submit" value="recharge" >
</form>
</body>
</html>