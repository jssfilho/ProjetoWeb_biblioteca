<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List, br.com.biblioteca.models.Obra"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Obra</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	el_select = $("select[name=lista]");
	el_select.hide();
	$.each(el_select.find("option"), function(){
		$("#novo_select_container ul").append(
		'<li><input type="checkbox" value="'+$(this).val()+'" />'+$(this).text()+'</li>'
		);
	});

	$("#novo_select input[type=checkbox]").on("click",function(){
		if($(this).is(":checked")){
			$("select[name=lista] option[value="+$(this).val()+"]").attr("selected","selected");
		}else{
			$("select[name=lista] option[value="+$(this).val()+"]").removeAttr("selected");
		}
	});

	$("#novo_select li:not(:eq(0))").on("click",function(){
		$(this).find("input").trigger("click");
	});

	$("#novo_select_container li:eq(0)").on("click", function(){
		if($("#novo_select").hasClass("novo_select_fechado")){
			$("#novo_select").removeClass("novo_select_fechado").addClass("novo_select_aberto");
			$("#novo_select_container").css("height","auto");
		}else{
			$("#novo_select").removeClass("novo_select_aberto").addClass("novo_select_fechado");
			$("#novo_select_container").css("height","21px");
		}
	});

	$("#novo_select_container li input, #novo_select_container li").on("click", function(e){
		e.stopPropagation();
	});
	
	$(document).on('click',function(){
		if($("#novo_select").hasClass("novo_select_aberto")){
			$("#novo_select").removeClass("novo_select_aberto").addClass("novo_select_fechado");
			$("#novo_select_container").css("height","21px");
		}
	});
});
</script>

<style type="text/css">
#novo_select_container{
	position: relative;
	height: 21px;
	display: inline-block;
}

#novo_select{
	background: #ddd;
}

#novo_select li, #novo_select ul{
	padding: 0;
	margin: 0;
}

#novo_select li{
	padding: 0 10px;
	line-height: 25px;
	cursor: default;
}

#novo_select li:first-child{
	background: url(https://www.materialui.co/materialIcons/navigation/arrow_drop_down_grey_192x192.png) right no-repeat;
	background-size: contain;
	padding-right: 25px;
}

.novo_select_aberto{
	position: relative;
	display: inline-block;
}

.novo_select_fechado{
	position: absolute;
	clip: rect(0px 1000px 25px 0px);
}
</style>

</head>
<body>

	<form action="/obras/formNovaObra" method="POST">
		Titulo:<input placeholder="Titulo da Obra" type="text" name="titulo"/>
		<br><br>
		Descricao:<TextArea placeholder="Descrição da Obra" type="text" name="descricao" ></TextArea>
		
		<br><br>
		
		<label for="cars">Selecione os Autores:</label>
		<br>
		<select multiple name="lista">
		  <c:forEach items="${autores}" var="autor">
				<option value=${autor.getCodigo() }>${autor.getNome() }</option>
			</c:forEach>
		</select>
		<div id="novo_select_container">
			<div id="novo_select" class="novo_select_fechado"><ul><li>Selecione...</li></ul></div>
		</div>
		
				<br><br>
		
		<label for="cars">Selecione a Editora:</label>
			<select name="idEditora" id="idEditora">
				<c:forEach items="${editoras}" var="editora">
				<option value=${editora.getCodigo() }>${editora.getNome() }</option>
			</c:forEach>
		</select>
		
				<br><br>
		
		<label for="cars">Selecione a Colecao:</label>
			<select  name="idColecao" id=""idColecao"">
				<c:forEach items="${colecoes}" var="colecao">
				<option value=${colecao.getCodigo() }>${colecao.getNome() }</option>
			</c:forEach>
		</select>
	<br><br>
					
		<input type="submit" >
	</form>
	<a href="/">Voltar</a>

</body>
</html>