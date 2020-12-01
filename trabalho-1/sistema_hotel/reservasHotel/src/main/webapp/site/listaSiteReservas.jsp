<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Sites de Reserva</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Gerenciamento de Sites de Reserva</h1>
		<h2>
			<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/sites/cadastro">Adicione Novo Site</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Sites</caption>
			<tr>
				<th>Url</th>
				<th>Nome</th>
				<th>Email</th>
			</tr>
			<c:forEach var="site" items="${requestScope.listaSiteReservas}">
				<tr>
					<td>${site.url}</td>
					<td>${site.nome}</td>
                    <td>${site.email}</td>
                    <td>
                        <a href="/<%= contextPath%>/sites/remocao?url=${site.url}"
						onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            Remoção </a>
                    </td>
                    <td>
                        <a href="/<%= contextPath%>/sites/edicao?url=${site.url}">Edição</a>
                    </td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>