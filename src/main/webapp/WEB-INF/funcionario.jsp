
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SVIM - Funcionario</title>
        <link rel="shortcut icon" href="imagens/favicon.ico"/>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="funcionario.js"></script>
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
                        <li><a href="">Venda</a></li>
                        <li><a href="">Estoque</a></li>
                        <li><a href="">Relatório</a></li>
                        <li><a href="./FilialListar">Filial</a></li>
                        <li><a href="./CargoListar">Cargo</a></li>
                        <li><a href="./FuncionarioListar">Funcionario</a></li>                      
                        <li><a href="./ProdutoListar">Produto</a></li>
                        <li><a href="./TipoProdutoListar">Tipo de Produto</a></li>
                    </ul>
                </aside>


                <section class="col-md-10" id="principal">
                    <article class="page-header">
                        <h1 class="txt">Funcionario</h1>
                        <p class="txt">Controle de funcionarios</p>
                    </article>


                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#cadastrarFuncionario">Cadastrar</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editarFuncionario">Editar</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deletarFuncionario">Deletar</button>

                    <table class="table table-hover">
                        <thead>				
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>CPF</th>
                                <th>Data Nascimento</th>
                                <th>Data Admissão</th>
                                <th>ID Cargo</th>
                                <th>Cargo</th>
                                <th>ID Filial</th>
                                <th>Filial</th>
                                <th>Senha</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="funcionario" items="${ListFuncionario}">
                                <tr>
                                    <td>${funcionario.getIdFuncionario()}</td>
                                    <td>${funcionario.getNome()}</td>
                                    <td>${funcionario.getCpf()}</td>
                                    <td>${funcionario.getDataNascimento()}</td>
                                    <td>${funcionario.getDataAdmissao()}</td>
                                    <td>${funcionario.getCargo().getIdCargo()}</td>
                                    <td>${funcionario.getCargo().getCargo()}</td>
                                    <td>${funcionario.getFilial().getIdFilial()}</td>
                                    <td>${funcionario.getFilial().getNomeFilial()}</td>
                                    <td>${funcionario.getSenha()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <br/>


                    <!-- Modal - Editar -->
                    <div class="modal fade" id="editarFuncionario" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Editar Funcionario</h4>
                                </div>

                                <div class="modal-body">
                                    <form method="POST" action="./FuncionarioAlterar">

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="nome">Nome:</label>
                                                <input type="text" name="nome" class="form-control" required>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="cpf">CPF:</label>
                                                <input type="text" name="cpf" class="form-control" required>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="dtnasc">Data Nascimento:</label>
                                                <input type="text" name="dtnasc" placeholder="yyyy-mm-dd" class="form-control" required>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="dtadm">Data Admissão</label>
                                                <input type="text" name="dtadm" placeholder="yyyy-mm-dd" class="form-control" required>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="cargo">Cargo:</label>
                                                <select name="cargo" class="form-control" required>
                                                    <c:forEach var="cargo" items="${ListCargo}">
                                                        <option value="${cargo.getIdCargo()}">
                                                            ${cargo.getCargo()}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="filial">Filial</label>
                                                <select name="filial" class="form-control" required>
                                                    <c:forEach var="filial" items="${ListFilial}">
                                                        <option value="${filial.getIdFilial()}">
                                                            ${filial.getNomeFilial()}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="senha">Senha:</label>
                                                <input type="text" name="senha" class="form-control" required>
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
                    <div class="modal fade" id="cadastrarFuncionario" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Cadastrar Funcionario</h4>
                                </div>

                                <div class="modal-body">
                                    <form method="POST" action="./FuncionarioCadastrar">

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="nome">Nome:</label>
                                                <input type="text" name="nome" class="form-control" required>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="cpf">CPF:</label>
                                                <input type="text" name="cpf" class="form-control" required>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="dtnasc">Data Nascimento:</label>
                                                <input type="text" name="dtnasc" placeholder="yyyy-mm-dd" class="form-control" required>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="dtadm">Data Admissão</label>
                                                <input type="text" name="dtadm" placeholder="yyyy-mm-dd" class="form-control" required>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="cargo">Cargo:</label>
                                                <select name="cargo" class="form-control" required>
                                                    <c:forEach var="cargo" items="${ListCargo}">
                                                        <option value="${cargo.getIdCargo()}">
                                                            ${cargo.getCargo()}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="filial">Filial</label>
                                                <select name="filial" class="form-control" required>
                                                    <c:forEach var="filial" items="${ListFilial}">
                                                        <option value="${filial.getIdFilial()}">
                                                            ${filial.getNomeFilial()}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="senha">Senha:</label>
                                                <input type="text" name="senha" class="form-control" required>
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
                    <div class="modal fade" id="deletarFuncionario" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Excluir Funcionario</h4>
                                </div>

                                <div class="modal-body">
                                    <form method="POST" action="./FuncionarioDeletar">
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

            <footer class="row" id="rodape">
                <div class="col-md-12">
                    <p>Sistema SVIM -  Todos os direitos reservados ®</p>
                </div>			
            </footer>
        </div>
    </body>
</html>