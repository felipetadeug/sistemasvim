<%-- 
    Document   : CadastroFilial
    Created on : 18/04/2017, 11:42:38
    Author     : Cauê Ghetti
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
        <h1>Cadastro Filial</h1>
        <form id="CadastroFilialForm" action="./FilialControl">
            <table>
                <div id="Campos">
                    <tr>
                        <td>
                            Nome
                        </td>
                        <td>
                            <input type="text" id="FilialNome" value=""/>
                        </td>
                        <td>
                            CEP
                        </td>
                        <td>
                            <input type="text" id="FilialCEP" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Endereço
                        </td>
                        <td>
                            <input type="text" id="FilialRua" value=""/>
                        </td>
                        <td>
                            Numero
                        </td>
                        <td>
                            <input type="text" id="FilialNumero" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Bairro
                        </td>
                        <td>
                            <input type="text" id="FilialBairro" value=""/>
                        </td>
                        <td>
                            Cidade
                        </td>
                        <td>
                            <input type="text" id="FilialCidade" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            UF
                        </td>
                        <td>
                            <input type="text" id="FilialUF" value=""/>
                        </td>
                        <td>
                            <div align="center">-</div>
                        </td>  
                </div>
                <td>
                    <input type="submit" name="FilialConfirma" value="Cadastrar"/>
                </td>
                </tr>
            </table>
    </center>
</form>
</body>
</html>
