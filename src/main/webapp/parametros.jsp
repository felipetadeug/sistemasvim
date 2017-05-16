<%-- 
    Document   : parametros.jsp
    Created on : 16/05/2017, 16:44:45
    Author     : Cauê Ghetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>

<html lang="en">
    <head>
        <title>SVIM - Parâmetros</title>
        <link rel="shortcut icon" href="imagens/favicon.ico"/>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="editar_parametros.js"></script>
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
                        <li><a href="venda.jsp">Venda</a></li>
                        <li><a href="./CargoListar">Parâmetros</a></li>
                    </ul>
                </aside>

                <section class="col-md-10" id="principal">
                    <article class="page-header">
                        <h1 class="txt">Parâmetros</h1>
                        <p class="txt">Controle os parâmetros no sistema.</p>
                    </article>

                    <form class="well well-lg" action="./CargoCadastrar">
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="cargos">Cargos:</label>
                                <input type="text" name="cargos" class="form-control">
                            </div>
                        </div>

                        <br/>

                        <button type="reset" class="btn btn-danger">Limpar</button>
                        <button type="submit" class="btn btn-success">Cadastrar</button>
                    </form>

                    <div class="well well-lg ">					
                        <table class="table table-hover">
                            <thead>				
                                <tr>
                                    <th>ID</th>
                                    <th>Cargos de Funcionarios</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cargo" items="${ListCargo}">
                                    <tr>
                                        <td>${cargo.getIdCargo()}</td>
                                        <td>${cargo.getCargo()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalCargos">Editar Selecionado</button>

                        <div class="modal fade" id="myModalCargos" role="dialog">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Editar Parâmetros - Cargos</h4>
                                    </div>

                                    <div class="modal-body">
                                        <form action="./CargoAlterar">
                                            <div class="row">
                                                <div class="form-group col-md-12">
                                                    <label for="nome">Nome:</label>
                                                    <input type="text" name="nome" class="form-control" >
                                                </div>
                                            </div>

                                            <input type="hidden" name="id">

                                            <br/>

                                            <button type="submit" class="btn btn-success">Atualizar</button>
                                        </form>
                                    </div>
                                </div>
                            </div>			
                        </div>  
                </section>
            </div>
        </div>

        <footer class="row" id="rodape">
            <div class="col-md-12">
                <p>Sistema SVIM -  Todos os direitos reservados ®</p>
            </div>			
        </footer>
    </div>
</body>
</html>

