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
			
				<c:if test = "${sessionScope.usuarioLogado.papel == 'ADMIN'}">
					<a href="/<%=contextPath%>/hotels/cadastro">Adicione Novo Hotel</a>
					<a href="/<%=contextPath%>/hotels/promocoes">Veja as promocoes</a>
				</c:if>
				<c:if test = "${sessionScope.usuarioLogado.papel == 'HOTEL'}">
					<a href="/<%=contextPath%>/hotels/promocoes">Veja as promocoes</a>
				</c:if>
			
			</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Livros</caption>
			<tr>
				<th>Nome</th>
				<th>Cidade</th>
				<th>Email</th>
			</tr>
			<c:forEach var="hotel" items="${requestScope.listaHotels}">
				<tr>
					<td>${hotel.nome}</td>
					<td>${hotel.cidade}</td>
					<td>${hotel.email}</td>
					
						<c:if test = "${sessionScope.usuarioLogado.papel == 'ADMIN'}">
							<td>
								<a href="/<%= contextPath%>/hotels/remocao?cnpj=${hotel.CNPJ}"
								onclick="return confirm('Tem certeza de que deseja excluir este item?');">
									Remoção </a>
							</td>
							<td>
								<a href="/<%= contextPath%>/hotels/edicao?cnpj=${hotel.CNPJ}">Edição</a>
							</td>
						</c:if>
					
				</tr>
			</c:forEach>
		</table>
		<form method = "POST" action="/<%=contextPath%>/hotels/cidade" id = "cidades">
			<select name="cidade" id="cidade" form= "cidades">
				<c:forEach var="cidad" items="${requestScope.listaCidades}">
					<option value='${cidad}'>${cidad}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>