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
<style type="text/css">
	table {
    width: 100%;
  	text-align: center;
}
table, td {
  border: 1px solid black;
  }
</style>
</head>
<body>
	<h3>Autores Salvos</h3>
	<table style=" border:1px; border-color:#000;">
		 <tr>
		 	<td>
		 		#ID
		 	</td>
		 	 <td>
				NOME
		 	</td>
		  	<td>
		 		EMAIL
		 	</td>		
		   <td>
		 		REMOVER
		 	</td> 
		</tr>
	<c:forEach items="${autores}" var="autor">
		<tr>
			<td>
				<label>${ autor.getCodigo() }</label>
			</td>
			<td>
				<label>${ autor.getNome() }</label>
			</td>
			<td>
				<label>${ autor.getEmail() }</label>
			</td>
			<td>
				<form action="/biblioteca/autores/listaAutores" method="POST">
					<button type="submit" name="codigo" value="${autor.getCodigo() }">EXCLUIR</button>
				</form>
			</td>
		<tr>
		</li>
	</c:forEach>
	</table>
	<a href="/biblioteca/">Voltar</a>
</body>
</html>