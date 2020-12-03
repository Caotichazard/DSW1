<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<fmt:bundle basename="messages"> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="AutentUser"/></title>
        <link rel="stylesheet" type="text/css" href="./CSS/main.css"/>
    </head>
    <body>
        <%
		    String contextPath = request.getContextPath().replace("/", "");
	    %>
        <h1><fmt:message key="AutentUser"/></h1>
        <c:if test="${mensagens.existeErros}">
            <div id="erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <form method="post" action="/<%=contextPath%>/logins/entry">
            <table>
                <tr>
                    <th><fmt:message key="login"/>: </th>
                    <td><input type="text" name="login"
                               value="${param.login}"/></td>
                </tr>
                <tr>
                    <th><fmt:message key="senha"/>: </th>
                    <td><input type="password" name="senha" /></td>
                </tr>
                <tr>
                    <td colspan="2"> 
                        <input type="submit"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</fmt:bundle>
</html>