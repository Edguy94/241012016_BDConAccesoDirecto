<%-- 
    Document   : TodosPollos
    Created on : 24-oct-2016, 17:33:05
    Author     : rpk19
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="es.albarregas.beans.Ave"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action='AccesoBD' method='post'>
        <%ArrayList<Ave> aves =(ArrayList<Ave>) request.getAttribute("aves");%>
        <table>
            <tr>
                  <th> Anilla </th><th>Especie</th><th>Lugar</th><th>Fecha</th>
            </tr>
       
      <%
          for(Ave ave: aves){
              %>
            <tr>
                <td><%=ave.getAnilla()%></td><td><%=ave.getEspecie()%></td><td><%=ave.getLugar()%></td><td><%=ave.getFecha()%></td>
            </tr>
              <%
          }
      %>
       </table>
        </form>
    </body>
</html>
