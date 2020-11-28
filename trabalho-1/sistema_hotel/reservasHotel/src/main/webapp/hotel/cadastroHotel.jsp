<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <fmt:bundle basename="messages">
            <form method="POST" >
                <fieldset >
                    <legend><fmt:message key="cadastroHotel"/></legend>
                    <fmt:message key="email"/><input type="text" name="email" /><br/>
                    <fmt:message key="senha"/><input type="text" name="senha" /><br/>
                    <fmt:message key="nomeHotel"/><input type="text" name="nome" /><br/>
                    <fmt:message key="cnpj"/><input type="text" name="cnpj" /><br/>
                    <fmt:message key="cidade"/><input type="text" name="cidade" /><br/>
                    <input type="submit" value="<fmt:message key="input"/>" />
                </fieldset>
            </form>
        </fmt:bundle>
    </body>
</html>