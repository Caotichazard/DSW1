<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<fmt:bundle basename="messages">	
<head>
<title><fmt:message key="LivVirtual"/></title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1><fmt:message key="GereHotel"/></h1>
		<h2>
			<a href="/<%=contextPath%>"><fmt:message key="MenuPrincipal"/>Menu Principal</a> &nbsp;&nbsp;&nbsp;
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption><fmt:message key="ListaLivros"/></caption>
			<tr>
                <th><fmt:message key="Site"/></th>
				<th><fmt:message key="Inicio"/></th><%-- tem que fazer a parte de localização disso--%>
				<th><fmt:message key="Fim"/></th>
				<th><fmt:message key="Preco"/></th>
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
</fmt:bundle>
</html>