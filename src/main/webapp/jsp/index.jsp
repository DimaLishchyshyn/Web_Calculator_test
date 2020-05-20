
   <%@ page language="java" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebCalculator</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
 
td, th {
    text-align: left;
    padding: 6px;
}
 
tr:nth-child(even), input {
    background-color: #dddddd;
}
</style>
</head>
<body>

<h3>ax^2 + bx + c = 0</h3>
<a>Введите значения коэффициентов <b>a</b>, <b>b</b> и <b>c</b></a>

<form action="/add-new-numbers" method="POST">
<input type="text" name="a">
<label><b>a:</b></label><br>
<input type="text" name="b">
<label><b>b:</b></label><br>
<input type="text" name="c">
<label><b>c:</b></label><br>
<input type="submit" value="Рассчитать">
</form>

<table>
  <c:forEach var="numbers" items="${numberList}">
 <tr>
 <td>${numbers.a}</td>
 <td>${numbers.b}</td>
 <td>${numbers.c}</td>
 <td>${numbers.msg}</td>
 <td></td>
 </tr>
 </c:forEach>
</table>
</body>

</html>