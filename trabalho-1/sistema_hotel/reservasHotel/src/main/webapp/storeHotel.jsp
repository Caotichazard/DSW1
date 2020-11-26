<%@ page import="br.ufscar.dc.dsw.beans.Hotel" %>
<%
    String email = request.getParameter("email"); 
    String senha = request.getParameter("senha");
    String nomeHotel = request.getParameter("nomeHotel");
    String cnpj = request.getParameter("cnpj");
    String cidade = request.getParameter("cidade");
    
    Hotel hotel = new Hotel(email,senha,cnpj,nomeHotel,cidade);
	session.setAttribute("cadastroHotel", hotel);
%>
	<jsp:forward page="index.jsp" />