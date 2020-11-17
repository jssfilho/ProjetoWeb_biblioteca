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
<meta name="viewport" content="width=device-width, initial-scale=1">

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
	<h3>Editoras Salvas</h3>
	<table style=" border:1px; border-color:#000;">
		 <tr>
		 	<td>
		 		#ID
		 	</td>
		 	 <td>
				NOME
		 	</td>
		  	<td>
		 		CPRF/CNPJ
		 	</td>		
		   <td>
		 		REMOVER
		 	</td> 
		</tr>
	<c:forEach items="${editoras}" var="editora">
		<tr>
			<td>
				<label>${ editora.getCodigo() }</label>
			</td>
			<td>
				<label>${ editora.getNome() }</label>
			</td>
			<td>
				<label>${ editora.getCnpj() }</label>
			</td>
			<td>
				<form action="/biblioteca/editoras/listaEditoras" method="POST">
					<button type="submit" name="codigo" value="${editora.getCodigo() }">EXCLUIR</button>
				</form>
			</td>
		</tr>
	</c:forEach>
	</table>
	<a href="/biblioteca/">Voltar</a>
</body>
</html>