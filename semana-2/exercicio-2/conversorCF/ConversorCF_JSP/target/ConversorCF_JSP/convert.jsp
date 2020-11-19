<%@ page import="br.ufscar.dc.dsw.beans.Conversor" %>
<%
    String minTempVal = request.getParameter("minTemp");
    int minTemp = (minTempVal == null || minTempVal == "") ? -100 : Integer.parseInt(minTempVal);
    String maxTempVal = request.getParameter("maxTemp");
    int maxTemp = (maxTempVal == null || maxTempVal == "") ? 100 : Integer.parseInt(maxTempVal);
    String incrementoVal = request.getParameter("increment");
    int increment = (incrementoVal == null || incrementoVal == "") ? 5 : Integer.parseInt(incrementoVal);
	if(minTemp < maxTemp) {
    	Conversor conversor = new Conversor();
        conversor.setMin(minTemp);
        conversor.setMax(maxTemp);
        conversor.setInc(increment);
    	session.setAttribute("conversor", conversor);
%>
		<jsp:forward page="principal.jsp"/>
<% }
   else { %>
		<jsp:forward page="index.jsp" />
<% } %>