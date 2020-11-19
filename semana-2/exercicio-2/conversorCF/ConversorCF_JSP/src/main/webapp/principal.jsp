<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page session="true" %>
<%@ page import="br.ufscar.dc.dsw.beans.Conversor" %>
<!DOCTYPE html>
<html>
    <head>
        <style>
            table, th, td {
              border: 1px solid black;
              border-collapse: collapse;
            }
            th, td {
                padding: 15px;
            }
            </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Celsius</th>
                <th>Fahrenheit</th>
            </tr>
            <% 
            Conversor conversor = (Conversor) session.getAttribute("conversor");
            
            int maxTemp=conversor.getMax();
            int minTemp=conversor.getMin();
            int inc=conversor.getInc();
            for(int i=minTemp;i <= maxTemp;i += inc) {
                double farh = i*1.8 + 32;
         %>
            <tr>
                <td> <%= i %></th>
                <td> <%= farh %> </th>
            </tr>
         <% } %>
            
            
        </table>
    </body>
</html>