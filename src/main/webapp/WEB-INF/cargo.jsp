
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SVIM - Cargo</title>
        <link rel="shortcut icon" href="imagens/favicon.ico"/>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="produto.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <header class="row" id="superior">
                <div class="container-fluid"  style="background-color:black;color:#fff;height:100px;">
                    <h1>SVIM</h1>
                    <div class="pull-right"><a href="./Sair"> Sair</a></div>
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
                        <h1 class="txt">Cargo</h1>
                        <p class="txt">Controle de cargos</p>
                    </article>
                    

                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#cadastrarCargo">Cadastrar</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editarCargo">Editar</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deletarCargo">Deletar</button>

                    <table class="table table-hover">
                        <thead>				
                            <tr>
                                <th>ID</th>
                                <th>Cargo</th>
                                <th>Hierarquia</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cargo" items="${ListCargo}">
                                <tr>
                                    <td>${cargo.getIdCargo()}</td>
                                    <td>${cargo.getCargo()}</td>
                                    <td>${cargo.getHierarquia()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <br/>


                    <!-- Modal - Editar -->
                    <div class="modal fade" id="editarCargo" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Editar Cargo</h4>
                                </div>

                                <div class="modal-body">
                                    <form method="POST" action="./CargoAlterar">
                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="cargo">Cargo:</label>
                                                <input type="text" name="cargo" class="form-control" required>
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="hierarquia">Hierarquia:</label>
                                                <input type="number" name="hierarquia" min="1" max="3" value="1" class="form-control" required>
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
                    <div class="modal fade" id="cadastrarCargo" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Cadastrar Cargo</h4>
                                </div>

                                <div class="modal-body">
                                    <form method="POST" action="./CargoCadastrar">
                                        
                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="cargo">Cargo:</label>
                                                <input type="text" name="cargo" class="form-control" required>
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="hierarquia">Hierarquia:</label>
                                                <input type="number" name="hierarquia" min="1" max="3" value="1" class="form-control" required>
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
                    <div class="modal fade" id="deletarCargo" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Excluir Cargo</h4>
                                </div>

                                <div class="modal-body">
                                    <form method="POST" action="./CargoDeletar">
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