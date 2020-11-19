package br.ufscar.dc.dsw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Conversoes" })
public class AloMundoServlet extends HttpServlet {
    
private static final long serialVersionUID = 1L;
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response, String metodo) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<style>");
        out.println("table, th, td {border: 1px solid black;border-collapse: collapse;}th, td {padding: 5px;}");
        out.println("</style>");
        out.println("<title>Servlet InterpretarRequestServlet</title>");
        out.println("</head>");
        out.println("<body>");
        String minTempVal = request.getParameter("minTemp");
        int minTemp = (minTempVal == null || minTempVal == "") ? -100 : Integer.parseInt(minTempVal);
        String maxTempVal = request.getParameter("maxTemp");
        int maxTemp = (maxTempVal == null || maxTempVal == "") ? 100 : Integer.parseInt(maxTempVal);
        String incrementoVal = request.getParameter("incremento");
        int incremento = (incrementoVal == null || incrementoVal == "") ? 5 : Integer.parseInt(incrementoVal);
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Celsius</th>");
        out.println("<th>Fahrenheit</th>");
        out.println("</tr>");
        for(int celsius = minTemp; celsius<=maxTemp; celsius+=incremento){
            double fahr = 1.8*celsius +32;
            out.println("<tr>");
            out.println("<td>" + celsius + "</td>");
            out.println("<td>" + fahr + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                processRequest(request, response, "GET");
}
           
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                processRequest(request, response, "POST");
}
}