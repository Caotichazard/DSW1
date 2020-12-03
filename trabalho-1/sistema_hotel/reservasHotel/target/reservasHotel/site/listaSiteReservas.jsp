<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<fmt:bundle basename="messages">
	<head>
		<title><fmt:message key="SiteReserva"/></title>
		<link rel="stylesheet" href="/CSS/main.css">
	</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1><fmt:message key="GerenDeSiteReserva"/></h1>
		<h2>
			<a href="/<%=contextPath%>"><fmt:message key="MenuPrincipal"/></a> &nbsp;&nbsp;&nbsp; 
			
			<c:if test = "${sessionScope.usuarioLogado.papel == 'ADMIN'}">
				<a href="/<%=contextPath%>/sites/cadastro"><fmt:message key="AddNovoSite"/></a>
			</c:if>
			<c:if test = "${sessionScope.usuarioLogado.papel == 'SITE'}">
					<a href="/<%=contextPath%>/sites/promocoes"><fmt:message key="VejaPromo"/></a>
			</c:if>
			
		</h2>
	</div>
		<div align="center">
			<table border="1">
				<caption>Lista de Sites</caption>
				<tr>
					
					<th><fmt:message key="URL"/></th>
					<th><fmt:message key="Nome"/></th>
					<th><fmt:message key="Email"/></th>

				</tr>
				<c:forEach var="site" items="${requestScope.listaSiteReservas}">
					<tr>
						<td>${site.url}</td>
						<td>${site.nome}</td>
						<td>${site.email}</td>
						
							<c:if test = "${sessionScope.usuarioLogado.papel == 'ADMIN'}">
								<td>
									<a href="/<%= contextPath%>/sites/remocao?url=${site.url}"
									onclick="return confirm('Tem certeza de que deseja excluir este item?');">
									<fmt:message key="Remocao"/></a>
								</td>
								<td>
									<a href="/<%= contextPath%>/sites/edicao?url=${site.url}"><fmt:message key="Edicao"/></a>
								</td>
							</c:if>
						
					</tr>
				</c:forEach>
			</table>
		</div
</body>
</fmt:bundle>
</html>
