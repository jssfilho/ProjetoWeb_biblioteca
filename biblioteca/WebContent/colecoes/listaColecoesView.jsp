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
	<h3>Colecoes Salvas</h3>
	<table style=" border:1px; border-color:#000;">
		 <tr>
		 	<td>
		 		#ID
		 	</td>
		 	 <td>
				NOME
		 	</td>
		  	<td>
		 		GENERO
		 	</td>		
		   <td>
		 		REMOVER
		 	</td> 
		</tr>
	<c:forEach items="${colecoes}" var="colecao">
		<tr>
			<td>
				<label>${ colecao.getCodigo() }</label>
			</td>
			<td>
				<label>${ colecao.getNome() }</label>
			</td>
			<td>
				<label>${ colecao.getGenero() }</label>
			</td>
			<td>
				<form action="/biblioteca/colecoes/listaColecoes" method="POST">
					<button type="submit" name="codigo" value="${colecao.getCodigo() }">EXCLUIR</button>
				</form>
			</td>
			
		</li>
		</tr>
	</c:forEach>
	</table>
	<a href="/biblioteca/">Voltar</a>
</body>
</html>