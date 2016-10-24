<%-- 
    Document   : unPollo
    Created on : 24-oct-2016, 17:32:45
    Author     : rpk19
--%>

<%@page import="es.albarregas.beans.Ave"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <H1>Mostrando su pajaro perdido</H1>
        <% Ave ave = (Ave)request.getAttribute("ave");%>
        <form action='AccesoBD' method='post'>
        <table>
            <tr>
                <th> Anilla </th><th>Especie</th><th>Lugar</th><th>Fecha</th>
                
            </tr>
            <tr>
                <td><%=ave.getAnilla()%></td><td><%=ave.getEspecie()%></td><td><%=ave.getLugar()%></td><td><%=ave.getFecha()%></td>
            </tr>
        </table>
        </form>
    </body>
</html>
