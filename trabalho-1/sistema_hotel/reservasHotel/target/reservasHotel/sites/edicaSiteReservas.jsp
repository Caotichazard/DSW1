<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <fmt:bundle basename="messages">
            <form method="POST" action="atualizacao">
                <fieldset >
                    <legend><fmt:message key="cadastroSiteReservas"/></legend>
                    <fmt:message key="email"/><input type="text" name="email" value="${site.email}" /><br/>
                    <fmt:message key="senha"/><input type="text" name="senha" value="${site.senha}"/><br/>
                    <fmt:message key="nomeSiteReservas"/><input type="text" name="nome" value="${site.nome}"/><br/>
                    <fmt:message key="url"/><input type="text" name="cnpj" value="${site.url}"/><br/>
                    <fmt:message key="telefone"/><input type="text" name="cidade" value="${site.telefone}"/><br/>
                    <input type="submit" value="<fmt:message key="input"/>" />
                </fieldset>
            </form>
        </fmt:bundle>
    </body>
</html>