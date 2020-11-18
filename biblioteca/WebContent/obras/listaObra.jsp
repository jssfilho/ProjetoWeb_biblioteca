<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Obras Cadastrados</title>
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
	<h3>Obras Cadastradas </h3>
	<table>
	 <tr>
		 <td>
		 #ID
		 </td>
		  <td>
		 TÍTULO
		 </td>
		  <td>
		 	DESCRIÇÃO
		 </td>
		 <td>
		 	REMOVER
		 </td>
		 
	</tr>
	
	<c:forEach items="${obras}" var="obra">
		 <tr>
			 <td>
				${obra.codigo}
			</td>
			 <td>
				${obra.titulo}
			</td>
			 <td>
				${obra.descricao}
			</td>
		<td>
			<form action="/obras/listaObra" method="POST">
				<button type="submit" name="codigo" value="${obra.getCodigo() }">EXCLUIR</button>
			</form>
		</td>
		 </tr>
	</c:forEach>
	</table>
	
	<a href="/">Voltar</a>
</body>
</html>