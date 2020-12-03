<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <fmt:bundle basename="messages">
            <form method="POST" action="insercao" id="cadastroPromo">
               
                    <br>
                    <fmt:message key="SiteReserva"/>
                        <select name='siteReserva' form="cadastroPromo">
                            <c:forEach var="site" items="${requestScope.listaSiteReserva}">
                                <option value='${site}'>${site}</option>
                            </c:forEach>
                        </select>
                    </br>
                    <input type="hidden" name="hotel" value="${sessionScope.usuarioLogado.login}" />
                    <fmt:message key="preco"/><input type="text" name="preco" /><br/>
                    <fmt:message key="dataInicio"/><input name="inicio" type="date"><br/>
                    <fmt:message key="dataFim"/><input name="fim" type="date"><br/>
                    <input type="submit" value="<fmt:message key="input"/>" />
                </fieldset>
            </form>
        </fmt:bundle>
    </body>
</html>