<%@ page import="br.ufscar.dc.dsw.beans.SiteReservas" %>
<%
    String email = request.getParameter("email"); 
    String senha = request.getParameter("senha");
    String nomeSiteReservas = request.getParameter("nomeSiteReservas");
    String url = request.getParameter("url");
    String telefone = request.getParameter("telefone");
    
    SiteReservas siteReservas = new SiteReservas(email,senha,url,nomeSiteReservas,telefone);
	session.setAttribute("siteReservas", siteReservas);
%>
	<jsp:forward page="index.jsp" />