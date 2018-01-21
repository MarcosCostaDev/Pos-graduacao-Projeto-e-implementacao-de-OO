<%@ page import="domain.Anunciante"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%
	Anunciante anunciante = (Anunciante) request.getAttribute("anunciante");
%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Cadatrar Anunciante</div>

	<form id="AnuncianteFormulario">

		<input type="hidden" name="id" value="<%=anunciante.getId()%>" /> <input
			type="hidden" name="isnew" value="<%=anunciante.isNovoRegistro()%>" />
		<div class="form-group">
			<label class="control-label required">Nome <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="nome"
				value="<%=anunciante.getNome()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Documento <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="documento"
				value="<%=anunciante.getDocumento()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Endereço <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="endereco"
				value="<%=anunciante.getEndereco()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Telefone <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="telefone"
				value="<%=anunciante.getTelefone()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Cidade <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="cidade"
				value="<%=anunciante.getCidade()%>" required />
		</div>

		<button class="btn btn-primary" type="button"
			onclick="onSalvarAnunciante()">Salvar</button>
		<button class="btn btn-primary" type="button"
			onclick="onVoltarAnunciante()">Voltar</button>

	</form>
</div>
<script type="text/javascript">
	<jsp:include page="/Anunciantes/EditarAnunciante.js" />
</script>