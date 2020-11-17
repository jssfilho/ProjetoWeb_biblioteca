<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.biblioteca.models.Autor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Obra</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<h3>Editar Obra</h3>
	<br />
	
		<c:forEach items="${obras}" var="obra">
			<form action="/biblioteca/obras/editarObra" method="POST">
				Nome: ${obra.getTitulo() }<br>
				Descrição:<br>
				<textArea type="text" name="novaDescricao">${obra.getDescricao()}</textArea><br>
			
				
				<button type="submit" name="codigo" value="${obra.getCodigo() }">EDITAR</button>
				<br />
			</form>
		</c:forEach>
	<br>
	<a href="/biblioteca/">Voltar</a>
</body>
</html>