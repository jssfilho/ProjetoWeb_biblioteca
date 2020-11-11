<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.biblioteca.models.Autor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autores Cadastrados</title>
</head>
<body>
	<h3>Autores Salvos</h3>
	<c:forEach items="${autores}" var="autor">
		<li>
			<label>${ autor.getCodigo() }</label><br>
			<label>${ autor.getNome() }</label><br>
			<label>${ autor.getEmail() }</label><br>
			<form action="/biblioteca/autores/listaAutores" method="POST">
				<button type="submit" name="codigo" value="${autor.getCodigo() }">EXCLUIR</button>
			</form>
			<br />
		</li>
	</c:forEach>
	<a href="/biblioteca/">Voltar</a>
</body>
</html>