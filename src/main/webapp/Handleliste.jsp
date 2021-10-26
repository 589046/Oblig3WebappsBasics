<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Handleliste</title>
</head>
<body>
	<div>
		<form action="Handleliste" method="post">
			<label>Skriv inn varen du vil legg til i handlelisten</label><br>
			<input type="text" name="leggTil" id="bla"><br>
			<input type="submit" value="Legg til vare">
		</form>
	</div>
	
	<div>
		<c:forEach items="${items}" var="i">
			<form action="Handleliste" method="post">
				<input type="submit" value="Slett vare">
				<input type="hidden" name="slett" value="${i}">
				<c:out value="${i}"/>
				<br>
			</form>
		</c:forEach>
	</div>

</body>
</html>