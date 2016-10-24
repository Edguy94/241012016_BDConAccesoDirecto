<%-- 
    Document   : index
    Created on : 24-oct-2016, 16:47:01
    Author     : rpk19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action='AccesoBD' method='post'>
            <p>Anilla <input type='text' name='txtAnilla'/></P>
                <input type='submit' value='buscar' name='uno'/>
                <input type='submit' value='imprimir todos' name='todos'/><BR>
                <p>Pajaros Aleatorios</p><input type='text' name='txtNumRandom'/></p>
                <input type='submit' value='obtener X pajaros random' name='btnRandom'/><BR>    
                    
                    
        </form>
    </body>
</html>
