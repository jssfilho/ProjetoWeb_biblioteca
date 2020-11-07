<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.biblioteca.models.Autor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Coleções</title>
</head>
<body>
	<h3>Colecoes Salvas</h3>
	<c:forEach items="${lista}" var="colecao">
		<li>
			<label>${ colecao.getCodigo() }</label>
			<label>${ colecao.getNome() }</label>
			<label>${ colecao.getGenero() }</label>
			<form action="/biblioteca/colecoes/listaColecoes" method="POST">
				<button type="submit" name="codigo" value="${colecao.getCodigo() }">EXCLUIR</button>
			</form>
		</li>
	</c:forEach>
</body>
</html>