<%-- 
    Document   : CadastrarFuncionario
    Created on : 09/05/2017, 20:25:44
    Author     : caue.ghetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- Tela - -->
<!-- Felipe Tadeu -->
<html lang="en">
    <head>
        <title>SVIM - Cadastrar Funcionário</title>
        <link rel="shortcut icon" href="imagens/favicon.ico"/>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <header class="row" id="superior">
                <div class="col-md-12">
                    <h1>SVIM</h1>
                </div>		
            </header>

            <div class="row">			
                <aside class="col-md-2" id="menu">
                    <ul>
                        <li><a href="cadastrar_item.jsp">Novo Cadastro - Item</a></li>
                        <li><a href="./ItemAlterar">Alterar Cadastro - Item</a></li>

                        <li><a href="./PopUpFuncionario">Novo Cadastro - Funcionario</a></li>
                        <li><a href="./FuncionarioListar">Alterar Cadastro - Funcionario</a></li>

                        <li><a href="cadastrar_filial.jsp">Novo Cadastro - Filial</a></li>
                        <li><a href="./ListarFilial">Alterar Cadastro - Filial</a></li>


                        <li><a href="">Estoque</a></li>
                        <li><a href="">Relatórios</a></li>
                        <li><a href="./CargoListar">Parâmetros</a></li>
                    </ul>
                </aside>

                <section class="col-md-10" id="principal">
                    <article class="page-header">
                        <h1 class="txt">Cadastrar Funcionario</h1>
                        <p class="txt">Insira os dados de seu funcionário.</p>
                    </article>

                    <form class="well well-lg">
                        <div class="row">
                            <div class="form-group col-md-8">
                                <label for="nome">Nome:</label>
                                <input type="text" name="nome" class="form-control" >
                            </div>

                            <div class="form-group col-md-4">
                                <label for="cpf">CPF:</label>
                                <input type="text" name="cpf" class="form-control">
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="data_nasc">Data de Nascimento:</label>
                                <input type="date" name="data_nasc" class="form-control">
                            </div>

                            <div class="form-group col-md-4">
                                <label for="data_ad">Data de Admissão:</label>
                                <input type="date" name="data_ad" class="form-control">
                            </div>						

                            <div class="form-group col-md-4">
                                <label for="cargo">Cargo:</label>
                                <select name="cargo" class="form-control">

                                    <c:forEach var="cargo" items="${ListCargo}">
                                        <option value="${cargo.getCargo()}">${cargo.getCargo()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-8">
                                <label for="filial">Filial:</label>
                                <select name="filial" class="form-control">

                                    <c:forEach var="filial" items="${ListFilial}">
                                        <option value="${filial.getNomeFilial()}">${filial.getNomeFilial()}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group col-md-4">
                                <label for="senha">Senha:</label>
                                <input type="password" name="senha" class="form-control">
                            </div>
                        </div>

                        <br/>

                        <button type="reset" class="btn btn-danger">Limpar</button>
                        <button type="submit" class="btn btn-success">Cadastrar</button>
                    </form>
                </section>
            </div>

            <footer class="row" id="rodape">
                <div class="col-md-12">
                    <p>Sistema SVIM -  Todos os direitos reservados ®</p>
                </div>			
            </footer>
        </div>
    </body>
</html>
