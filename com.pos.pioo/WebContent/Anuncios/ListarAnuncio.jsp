<%@ page import="domain.Anuncio"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Lista de anúncio</div>
	<div>
		<button class="btn btn-primary" type="button"
			onclick="onEditarAnuncio()">Novo Anúncio</button>
	</div>
	<!-- Table -->
	<table class="table">
		<tr>
			<th></th>
			<th>Categoria</th>
			<th>Anuncio</th>
			<th>Validade</th>

		</tr>
		<%
			List<Anuncio> anuncios = (List<Anuncio>) request.getAttribute("anuncios");
			for (Anuncio item : anuncios) {
		%>
		<tr>
			<td>
				<button type="button" class="btn btn-info btn-sm"
					onclick="onEditarAnuncio(<%=item.getId()%>)">
					<span class="fa fa-pencil"></span>
				</button>
				<button type="button" class="btn btn-danger btn-sm"
					onclick="onExluirAnuncio(<%=item.getId()%>)">
					<span class="fa fa-trash-o"></span>
				</button>
			</td>
			<td><%=item.getCategoria().getNome() %></td>
			<td><%=item.getAnunciante().getNome() %></td>
		</tr>
		<%
			}
		%>
	</table>
</div>


<script type="text/javascript">
	<jsp:include page="/Anuncios/ListarAnuncio.js" />
</script>
