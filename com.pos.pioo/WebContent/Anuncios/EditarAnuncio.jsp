<%@ page import="domain.Categoria"%>
<%@ page import="domain.Anunciante"%>
<%@ page import="domain.Anuncio"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%
	Anuncio anuncio = (Anuncio) request.getAttribute("anuncio");
	List<Categoria> categorias = (ArrayList<Categoria>) request.getAttribute("categorias");
	List<Anunciante> anunciantes = (ArrayList<Anunciante>) request.getAttribute("anunciantes");
%>

<form id="AnuncioFormulario">
	<input type="hidden" name="id" value="<%=anuncio.getId()%>">
	<input
		type="hidden" name="isnew" value="<%=anuncio.isNovoRegistro()%>" />
	<div class="form-group">

		<label class="control-label required">Categoria <abbr
			title="required">*</abbr>
		</label> <select name="categoriaId" require>
			<%
				for (Categoria item : categorias) {
			%>
			<option value="<%=item.getId()%>"
				<%=!anuncio.isNovoRegistro() && anuncio.getCategoria().getId() == item.getId() ? "selected" : ""%>><%=item.getNome()%></option>
			<%
				}
			%>
		</select>
	</div>
	<div class="form-group">
		<label class="control-label required">Anunciante <abbr
			title="required">*</abbr>
		</label> <select name="anuncianteId" require>
			<%
				for (Anunciante item : anunciantes) {
			%>
			<option value="<%=item.getId()%>"
				<%=!anuncio.isNovoRegistro() && anuncio.getAnunciante().getId() == item.getId() ? "selected" : ""%>><%=item.getNome()%></option>
			<%
				}
			%>
		</select>
	</div>
	<div class="form-group">
		<label class="control-label required">Validade <abbr
			title="required">*</abbr>
		</label> <input type="text" class="form-control" name="dataValidade"
			value="<%=anuncio.getDataValidade().toString() %>" required />
	</div>
	<button class="btn btn-primary" type="button"
		onclick="onSalvarAnuncio()">Salvar</button>
	<button class="btn btn-primary" type="button"
		onclick="onVoltarAnuncio()">Voltar</button>
</form>

<script type="text/javascript">
	<jsp:include page="/Anuncios/EditarAnuncio.js" />
</script>