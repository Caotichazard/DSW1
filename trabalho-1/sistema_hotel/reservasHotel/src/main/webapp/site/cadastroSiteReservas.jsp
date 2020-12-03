<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <link rel="stylesheet" href="CSS/main.css">
    </head>
    <body>
        <fmt:bundle basename="messages">
            <form method="POST" action="insercao">
                <fieldset >
                    <legend><fmt:message key="cadastroSiteReservas"/></legend>
                    <fmt:message key="email"/><input type="text" name="email" /><br/>
                    <fmt:message key="senha"/><input type="text" name="senha" /><br/>
                    <fmt:message key="nomeSiteReservas"/><input type="text" name="nome" /><br/>
                    <fmt:message key="url"/><input type="text" name="url" /><br/>
                    <fmt:message key="telefone"/><input type="text" name="telefone" /><br/>
                    <input type="submit" value="<fmt:message key="input"/>" />
                </fieldset>
            </form>
        </fmt:bundle>
    </body>
</html>