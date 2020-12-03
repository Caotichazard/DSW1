<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <fmt:bundle basename="messages">
            <form method="POST" action="atualizacao">
                <fieldset >
                    <legend><fmt:message key="cadastroHotel"/></legend>
                    <fmt:message key="email"/><input type="text" name="email" value="${hotel.email}" /><br/>
                    <fmt:message key="senha"/><input type="text" name="senha" value="${hotel.senha}"/><br/>
                    <fmt:message key="nomeHotel"/><input type="text" name="nome" value="${hotel.nome}"/><br/>
                    <fmt:message key="cnpj"/><input type="text" name="cnpj" value="${hotel.CNPJ}"/><br/>
                    <fmt:message key="cidade"/><input type="text" name="cidade" value="${hotel.cidade}"/><br/>
                    <input type="submit" value="<fmt:message key="input"/>" />
                </fieldset>
            </form>
        </fmt:bundle>
    </body>
</html>