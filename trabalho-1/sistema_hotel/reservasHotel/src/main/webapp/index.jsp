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
        <c:if test = "${sessionScope.usuarioLogado != null}">
            <h1>AAAAAAAAAAAAAA
            <c:out value="${sessionScope.usuarioLogado.papel}" />
            </h1>
        </c:if>
        <fmt:bundle basename="messages">
            <form action="sites" method="GET">
                <input type="submit"  value="<fmt:message key="reservas"/>"><br/>
            </form>
            
            <form action="hotels" method="GET">
                <input type="submit"  value="<fmt:message key="hotel"/>"><br/>
            </form>
            <form action="logins" method="GET">
                <input type="submit"  value="<fmt:message key="login"/>"><br/>
            </form>
            <c:if test = "${sessionScope.usuarioLogado != null}">
                <form action="logins" method="GET">
                    <input type="submit"  value="<fmt:message key="login"/>"><br/>
                </form>
            </c:if>
        </fmt:bundle>
    </body>
</html>