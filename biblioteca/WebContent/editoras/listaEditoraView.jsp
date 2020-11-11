<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.biblioteca.models.Autor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Editoras</title>
</head>
<body>
	<h3>Editoras Salvas</h3>
	<c:forEach items="${editoras}" var="editora">
		<li>
			<label>${ editora.getCodigo() }</label>
			<label>${ editora.getNome() }</label>
			<label>${ editora.getCnpj() }</label>
			<form action="/biblioteca/editoras/listaEditoras" method="POST">
				<button type="submit" name="codigo" value="${editora.getCodigo() }">EXCLUIR</button>
			</form>
		</li>
	</c:forEach>
	<a href="/biblioteca/">Voltar</a>
</body>
</html>