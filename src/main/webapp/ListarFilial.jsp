<%-- 
    Document   : ListarFilial
    Created on : 12/05/2017, 16:40:09
    Author     : Cauê Ghetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <p>Filiais</p>
        <table class=".table-striped">
            <tr>
                <td>Nome</td>
                <td>Rua</td>
                <td>Numero</td>
                <td>Bairro</td>
                <td>Cidade</td>
                <td>CEP</td>
                <td>UP</td>
            </tr>
            <c:forEach var="filial" items="${ListFilial}">
                <tr>
                    <td>${filial.getNomeFilial()}</td>
                    <td>${filial.getRua()}</td>
                    <td>${filial.getNumero()}</td>
                    <td>${filial.getBairro()}</td>
                    <td>${filial.getCidade()}</td>
                    <td>${filial.getCep()}</td>
                    <td>${filial.getUf()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
