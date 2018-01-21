<div>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand com-pos-pioo-menu-home" href="#">Publicidades</a>
			</div>

			<ul class="nav navbar-nav">
				<%
					if (request.getSession().getAttribute("usuarioLogado") != null) {
				%>
				<li><a class="com-pos-pioo-menu-categorias" href="#">Categorias</a></li>
				<li><a class="com-pos-pioo-menu-anunciantes" href="#">Anunciantes</a></li>
				<li><a class="com-pos-pioo-menu-anuncios" href="#">Anuncios</a></li>
				<li><a class="com-pos-pioo-menu-usuarios" href="#">Usuários</a></li>
				<li class="danger"><a class="com-pos-pioo-menu-logout" href="#">Sair</a></li>
				<%
					} else {
				%>
				<li><a class="com-pos-pioo-menu-login" href="#">Login</a></li>

				<%
					}
				%>
			</ul>

		</div>
	</nav>

	<script type="text/javascript">
		<jsp:include page="/Shared/menu.js" />
	</script>
</div>

