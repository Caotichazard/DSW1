<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <fmt:bundle basename="messages">
            <form action="convert.jsp" method="POST">
                <fieldset >
                    <legend><fmt:message key="converter"/></legend>
                    <fmt:message key="tempMax"/><input type="text" name="maxTemp" /><br/>
                    <fmt:message key="tempMin"/><input type="text" name="minTemp" /><br/>
                    <fmt:message key="increment"/><input type="text" name="increment" /><br/>
                    <input type="submit" value="<fmt:message key="input"/>" />
                </fieldset>
            </form>
        </fmt:bundle>
    </body>
</html>