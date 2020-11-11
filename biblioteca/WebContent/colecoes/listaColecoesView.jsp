<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.biblioteca.models.Autor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Cole��es</title>
</head>
<body>
	<h3>Colecoes Salvas</h3>
	<c:forEach items="${colecoes}" var="colecao">
		<li>
			<label>${ colecao.getCodigo() }</label><br>
			<label>${ colecao.getNome() }</label><br>
			<label>${ colecao.getGenero() }</label><br>
			<form action="/biblioteca/colecoes/listaColecoes" method="POST">
				<button type="submit" name="codigo" value="${colecao.getCodigo() }">EXCLUIR</button>
			</form>
			<br />
		</li>
	</c:forEach>
	<a href="/biblioteca/">Voltar</a>
</body>
</html>