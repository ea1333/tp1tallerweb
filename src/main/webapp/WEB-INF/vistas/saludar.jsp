<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
	<meta charset="UTF-8">
	<title>¡Hola ${nombre} ${apellido}!</title>
</head>
<body>
	<p>¡Hola ${nombre} ${apellido}!</p>
<c:forEach items="${tabla}" var="apellido">
	<h1>${apellido}</h1>
</c:forEach>
</body>
</html>