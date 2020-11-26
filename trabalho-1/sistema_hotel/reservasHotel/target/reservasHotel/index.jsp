<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <fmt:bundle basename="messages">
            <form action="cadastroSiteReservas.jsp" method="GET">
                <input type="submit"  value="<fmt:message key="reservas"/>"><br/>
            </form>
            
            <form action="cadastroHotel.jsp" method="GET">
                <input type="submit"  value="<fmt:message key="hotel"/>"><br/>
            </form>
            
        </fmt:bundle>
    </body>
</html>