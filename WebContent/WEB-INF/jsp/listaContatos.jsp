<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
		<title>Lista de contatos</title>
	</head>
<body>
	<%--<jsp:useBean id="dao" class="com.model.ContatoDao"></jsp:useBean>--%>
	
	<c:import url="cabecalho.jsp"></c:import>
	
	<a href="mvc?logica=ExibeFormulario"><button>Adicionar</button></a>

	<table>
		<c:forEach var="contato" items="${contatos}"> 
			<tr>
				<td>${contato.nome}</td>
				<td>
					<c:choose>
					<c:when test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:when>
					<c:otherwise>
						E-mail não informado
					</c:otherwise>
					</c:choose>
				</td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
				<td><a href="mvc?logica=RemoveContato&id=${contato.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>