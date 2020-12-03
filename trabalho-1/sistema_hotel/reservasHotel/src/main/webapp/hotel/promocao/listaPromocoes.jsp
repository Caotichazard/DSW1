<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Livraria Virtual</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Gerenciamento de Hoteis</h1>
		<h2>
			<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp;
			
				<c:if test = "${sessionScope.usuarioLogado.papel == 'ADMIN' || sessionScope.usuarioLogado.papel == 'HOTEL'}">
					<a href="/<%=contextPath%>/hotels/promocoes/cadastro">Adicione Nova Promocao</a>
				</c:if>
			
			</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Livros</caption>
			<tr>
                <th>Site</th>
				<th>Inicio</th><%-- tem que fazer a parte de localização disso--%>
				<th>Fim</th>
				<th>Preco</th>
			</tr>
			<c:forEach var="promocao" items="${requestScope.listaPromocaos}">
				<tr>
                    <td>${promocao.urlSite}</td>
					<td>${promocao.inicio}</td>
					<td>${promocao.fim}</td>
					<td>${promocao.preco}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>