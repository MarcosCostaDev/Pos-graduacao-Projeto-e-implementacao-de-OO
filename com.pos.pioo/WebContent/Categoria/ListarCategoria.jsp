<%@ page import="domain.Categoria"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Lista de categorias</div>
	<div>
		<button class="btn btn-primary" type="button"
			onclick="onEditarCategoria()">Nova Categoria</button>
	</div>
	<!-- Table -->
	<table class="table">
		<tr>
			<th></th>
			<th>Nome</th>
		</tr>
		<%
			List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
			for (Categoria item : categorias) {
		%>
		<tr>
			<td>
				<button type="button" class="btn btn-info btn-sm"
					onclick="onEditarCategoria(<%=item.getId()%>)">
					<span class="fa fa-pencil"> </span>
				</button>
				<button type="button" class="btn btn-danger btn-sm"
					onclick="onExluirCategoria(<%=item.getId()%>)">
					<span class="fa fa-trash-o"></span>
				</button> 
			</td>
			<td><%=item.getNome()%></td>
		</tr>
		<%
			}
		%>
	</table>
</div>

<script
	src="${pageContext.request.contextPath}/Categoria/ListarCategoria.js"
	type="text/javascript"></script>