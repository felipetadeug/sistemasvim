<%-- 
    Document   : AlterarFilial
    Created on : 18/04/2017, 20:45:41
    Author     : luis.hlsousa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Alterar Filial</h1>
        <form id="AlteraFilialForm" action="./FilialControl">
            <table>
                <div id="Campos">
                    <tr>
                        <td>
                            Nome
                        </td>
                        <td>
                            <input type="text" name="FilialNome" value=""/>
                        </td>
                        <td>
                            CEP
                        </td>
                        <td>
                            <input type="text" name="FilialCEP" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Endereço
                        </td>
                        <td>
                            <input type="text" name="FilialRua" value=""/>
                        </td>
                        <td>
                            Numero
                        </td>
                        <td>
                            <input type="text" name="FilialNumero" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Bairro
                        </td>
                        <td>
                            <input type="text" name="FilialBairro" value=""/>
                        </td>
                        <td>
                            Cidade
                        </td>
                        <td>
                            <input type="text" name="FilialCidade" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            UF
                        </td>
                        <td>
                            <input type="text" name="FilialUF" value=""/>
                        </td>
                        <td>
                            <div align="center">-</div>
                        </td>  
                </div>
                <td>
                    <input type="submit" name="FilialConfirma" value="Alterar"/>
                    <input type="submit" name="FilialCancela" value="Cancelar"/>
                </td>
                </tr>
            </table>
    </center>
</form>
</body>
</html>
