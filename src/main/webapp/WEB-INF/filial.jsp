
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SVIM - Filial</title>
        <link rel="shortcut icon" href="imagens/favicon.ico"/>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="filial.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <header class="row" id="superior">
                <div class="container-fluid"  style="background-color:black;color:#fff;height:100px;">
                    <h1>SVIM</h1>
                    <p>Seja bem vindo.</p>
                </div>			
            </header>


            <div class="row">			
                
                <ul class="col-md-2 nav nav-pills nav-stacked">                  
                    <li class="active"><a href="#">Operações</a></li>
                    <li><a href="./VendaListar">Venda</a></li>
                    <li><a href="">Estoque</a></li>
                    <li><a href="">Relatório</a></li>
                    <li><a href="./FilialListar">Filial</a></li>
                    <li><a href="./CargoListar">Cargo</a></li>
                    <li><a href="./FuncionarioListar">Funcionario</a></li>                      
                    <li><a href="./ProdutoListar">Produto</a></li>
                    <li><a href="./TipoProdutoListar">Tipo de Produto</a></li>
                </ul>

                <section class="col-md-10" id="principal">
                    <article class="page-header">
                        <h1 class="txt">Filial</h1>
                        <p class="txt">Controle de filiais</p>
                    </article>


                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#cadastrarFilial">Cadastrar</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editarFilial">Editar</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deletarFilial">Deletar</button>

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


                    <!-- Modal - Editar -->
                    <div class="modal fade" id="editarFilial" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Editar Filial</h4>
                                </div>

                                <div class="modal-body">
                                    <form method="POST" action="./FilialAlterar">
                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="nome">Nome:</label>
                                                <input type="nome" name="nome" class="form-control" required>
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="cep">CEP:</label>
                                                <input type="text" name="cep" class="form-control" required>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="endereco">Endereço:</label>
                                                <input type="text" name="endereco" class="form-control" required>
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="numero">Número:</label>
                                                <input type="text" name="numero" class="form-control" required>
                                            </div>						
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-4">
                                                <label for="bairro">Bairro:</label>
                                                <input type="text" name="bairro" class="form-control" required>
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="cidade">Cidade:</label>
                                                <input type="text" name="cidade" class="form-control" required>
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="uf">UF:</label>
                                                <select name="uf" class="form-control" required>
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

                    <!-- Modal - Cadastrar -->                    
                    <div class="modal fade" id="cadastrarFilial" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Cadastrar Filial</h4>
                                </div>

                                <div class="modal-body">
                                    <form method="POST" action="./FilialCadastrar">
                                        <div class="row">
                                            <div class="form-group col-md-9">
                                                <label for="nome">Nome:</label>
                                                <input type="text" name="nome" class="form-control" required>
                                            </div>

                                            <div class="form-group col-md-3">
                                                <label for="cep">CEP:</label>
                                                <input type="text" name="cep" class="form-control" required>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-9">
                                                <label for="endereco">Endereço:</label>
                                                <input type="text" name="endereco" class="form-control" required>
                                            </div>

                                            <div class="form-group col-md-3">
                                                <label for="numero">Número:</label>
                                                <input type="text" name="numero" class="form-control" required>
                                            </div>						
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-5">
                                                <label for="bairro">Bairro:</label>
                                                <input type="text" name="bairro" class="form-control" required>
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="cidade">Cidade:</label>
                                                <input type="text" name="cidade" class="form-control" required>
                                            </div>

                                            <div class="form-group col-md-3">
                                                <label for="uf">UF:</label>
                                                <select name="uf" class="form-control" required>
                                                    <c:forEach var="uf" items="${UFsList}">
                                                        <option value="${uf}">
                                                            ${uf}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>					
                                        </div>

                                        <br/>

                                        <button type="reset" class="btn btn-danger">Limpar</button>
                                        <button type="submit" class="btn btn-success">Cadastrar</button>
                                    </form>
                                </div>
                            </div>				      
                        </div>
                    </div>

                    <!-- Modal - Deletar -->                    
                    <div class="modal fade" id="deletarFilial" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Excluir Filial</h4>
                                </div>

                                <div class="modal-body">
                                    <form method="POST" action="./FilialDeletar">
                                        <h2>Tem certeza que deseja deletar este registro?</h2>
                                        <input type="hidden" name="id">
                                        <button type="submit" class="btn btn-danger">Deletar</button>
                                    </form>
                                </div>
                            </div>				      
                        </div>
                    </div>

                </section>
            </div>
        </div>
    </body>
</html>