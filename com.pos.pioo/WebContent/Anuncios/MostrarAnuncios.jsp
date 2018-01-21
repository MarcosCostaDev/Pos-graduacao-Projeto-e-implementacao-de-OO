<%@ page import="domain.Anuncio"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%
	ArrayList<Anuncio> anuncios = (ArrayList<Anuncio>) request.getAttribute("anuncios");
%>
<div class="row">
	<%
		for (Anuncio item : anuncios) {
	%>
	<div class="col-2">
		<h3><%=item.getCategoria().getNome()%></h3>
		<div>
			<%=item.getCategoria().getNome()%>
		</div>
	</div>
	<%
		}
	%>
</div>