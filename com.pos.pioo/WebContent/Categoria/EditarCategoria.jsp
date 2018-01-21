<%@ page import="domain.Categoria"%>

<%
	Categoria categoria = (Categoria) request.getAttribute("categoria");
%>

<form id="CategoriaFormulario">
	<input type="hidden" name="id" value="<%=categoria.getId()%>" /> <input
		type="hidden" name="isnew" value="<%=categoria.isNovoRegistro()%>" />
	<div class="form-group">
		<label class="control-label required">Nome <abbr
			title="required">*</abbr>
		</label> <input type="text" class="form-control" name="nome"
			value="<%=categoria.getNome()%>" required />
	</div>
	<button class="btn btn-primary" type="button"
		onclick="onSalvarCategoria()">Salvar</button>
	<button class="btn btn-primary" type="button"
		onclick="onVoltarCategoria()">Voltar</button>

</form>

<script type="text/javascript">
	<jsp:include page="/Categoria/EditarCategoria.js" />
</script>