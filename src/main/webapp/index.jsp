<%-- 
    Document   : index
    Created on : 16/04/2017, 19:24:35
    Author     : Cauê Ghetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SVIM Login</title>
    </head>
    <body>
        <form id="LoginForm" action="MainPage.jsp">
            <center>
                <h1>Login</h1>
                <br>
                <table>
                    <tr>
                        <td>Usuario: </td>
                        <td><input type="text" name="user" value=""/></td>
                    </tr>
                    <tr>
                        <td>Senha: </td>
                        <td><input type="password" name="senha" value=""/></td>
                    </tr>
                </table>
                <br>
                <input type="submit" name="btnLogin" value="Entrar"/>
            </center>
        </form>
    </body>
</html>
