<%@ page import="domain.Usuario"%>

<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
%>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Cadatrar Usuario</div>
	<form id="UsuarioFormulario">
		<input type="hidden" name="id" value="<%=usuario.getId()%>" /> <input
			type="hidden" name="isnew" value="<%=usuario.isNovoRegistro()%>" />
		<div class="form-group">
			<label class="control-label required">Nome <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="nome"
				value="<%=usuario.getNome()%>" required />
		</div>

		<div class="form-group">
			<label class="control-label required">Login <abbr
				title="required">*</abbr>
			</label> <input type="text" class="form-control" name="login"
				value="<%=usuario.getLogin()%>" required />
		</div>
		
		<div class="form-group">
			<label class="control-label required">Senha <abbr
				title="required">*</abbr>
			</label> <input type="password" class="form-control" name="senha"
				 required />
		</div>

		<button class="btn btn-primary" type="button"
			onclick="onSalvarUsuario()">Salvar</button>
		<button class="btn btn-primary" type="button"
			onclick="<%= request.getSession().getAttribute("usuarioLogado") == null ? "onVoltarLogin()" : "onVoltarUsuario()" %>">Voltar</button>
	</form>
</div>

<script type="text/javascript">
	<jsp:include page="/Usuario/EditarUsuario.js" />
</script>