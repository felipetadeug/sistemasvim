<%-- 
    Document   : alterar_filial
    Created on : 16/05/2017, 15:06:25
    Author     : Cauê Ghetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- Tela - Alterar Filial-->
<!-- Felipe Tadeu https://www.w3schools.com/bootstrap/bootstrap_grid_basic.asp // http://www.flextool.com.br/tabela_cores.html-->
<html lang="en">
    <head>
        <title>SVIM - Editar Filial</title>
        <link rel="shortcut icon" href="imagens/favicon.ico"/>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="editar_filial.js"></script>
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
                        <li><a href="./ListarItem">Alterar Cadastro - Item</a></li>

                        <li><a href="./PopUpFuncionario">Novo Cadastro - Funcionario</a></li>
                        <li><a href="./FuncionarioListar">Alterar Cadastro - Funcionario</a></li>

                        <li><a href="cadastrar_filial.jsp">Novo Cadastro - Filial</a></li>
                        <li><a href="./FilialListar">Alterar Cadastro - Filial</a></li>


                        <li><a href="">Estoque</a></li>
                        <li><a href="">Relatórios</a></li>
                        <li><a href="venda.jsp">Venda</a></li>
                        <li><a href="./CargoListar">Parâmetros</a></li>
                    </ul>
                </aside>


                <section class="col-md-10" id="principal">
                    <article class="page-header">
                        <h1 class="txt">Editar Filial</h1>
                        <p class="txt">Selecione o a filial a ser editada.</p>
                    </article>

                    <table class="table table-hover">
                        <thead>				
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>CEP</th>
                                <th>Endereço</th>
                                <th>Nº</th>
                                <th>Bairro</th>
                                <th>Cidade</th>
                                <th>UF</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="filial" items="${ListFilial}">
                            <tr>
                                <td>${filial.getIdFilial()}</td>
                                <td>${filial.getNomeFilial()}</td>
                                <td>${filial.getCep()}</td>
                                <td>${filial.getRua()}</td>
                                <td>${filial.getNumero()}</td>
                                <td>${filial.getBairro()}</td>
                                <td>${filial.getCidade()}</td>
                                <td>${filial.getUf()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <br/>

                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Editar Selecionado</button>

                    <div class="modal fade" id="myModal" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Editar Filial</h4>
                                </div>

                                <div class="modal-body">
                                    <form action="./FilialAlterar">
                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="nome">Nome:</label>
                                                <input type="nome" name="nome" class="form-control" >
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="cep">CEP:</label>
                                                <input type="text" name="cep" class="form-control">
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="endereco">Endereço:</label>
                                                <input type="text" name="endereco" class="form-control">
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="numero">Número:</label>
                                                <input type="text" name="numero" class="form-control">
                                            </div>						
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-4">
                                                <label for="bairro">Bairro:</label>
                                                <input type="text" name="bairro" class="form-control">
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="cidade">Cidade:</label>
                                                <input type="text" name="cidade" class="form-control">
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="uf">UF:</label>
                                                <select name="uf" class="form-control">
                                                    <option value="SP">SP</option>
                                                    <!-- Script para carregar UF-->
                                                </select>
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

            <footer class="row" id="rodape">
                <div class="col-md-12">
                    <p>Sistema SVIM -  Todos os direitos reservados ®</p>
                </div>			
            </footer>
        </div>
    </body>
</html>