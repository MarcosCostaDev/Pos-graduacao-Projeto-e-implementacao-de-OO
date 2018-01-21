<%@ page import="domain.Categoria"%>
<%@ page import="domain.Anunciante"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%
	List<Categoria> categorias = (ArrayList<Categoria>) request.getAttribute("categorias");
	List<Anunciante> anunciantes = (ArrayList<Anunciante>) request.getAttribute("anunciantes");
	String validade = (String) request.getAttribute("validade");
%>

<form
	action="${pageContext.request.contextPath}/Controller=SalvarCategoria">
	<div class="form-group">
		<label class="control-label required">Categoria <abbr
			title="required">*</abbr>
		</label> <select name="CategoriaId" require>
			<%
				for (Categoria item : categorias) {
			%>
			<option value="'<%=item.getId()%>'"><%=item.getNome()%></option>
			<%
				}
			%>
		</select>
	</div>

	<div class="form-group">
		<label class="control-label required">Categoria <abbr
			title="required">*</abbr>
		</label> <select name="AnuncianteId" require>
			<%
				for (Anunciante item : anunciantes) {
			%>
			<option value="'<%=item.getId()%>'"><%=item.getNome()%></option>
			<%
				}
			%>
		</select>
	</div>

	<div class="form-group">
		<label class="control-label required">Validade <abbr
			title="required">*</abbr>
		</label> <input type="text" class="form-control" name="nome"
			value="<%=validade%>" required />
	</div>


	<button class="btn btn-primary" type="submit">Salvar</button>
	<button class="btn btn-primary" type="button"
		onclick="onVoltarAnuncio()">Voltar</button>

</form>

<script type="text/javascript">
	<jsp:include page="/Anunciantes/EditarAnunciante.js" />
</script>