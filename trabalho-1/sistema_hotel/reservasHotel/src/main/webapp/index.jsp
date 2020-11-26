<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <fmt:bundle basename="messages">
            <form >
                <input type="button" name="reservas"><fmt:message key="reservas"/><br/>
            </form>
            
            <form action="cadastroHotel.jsp" method="GET">
                <input type="submit"  value="<fmt:message key="hotel"/>"><br/>
            </form>
            <form>
                <input type="button" name="promocao"><fmt:message key="promo"/><br/>
            </form>
        </fmt:bundle>
    </body>
</html>