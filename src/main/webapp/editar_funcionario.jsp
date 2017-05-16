<%-- 
    Document   : editar_funcionario
    Created on : 16/05/2017, 17:57:09
    Author     : Cauê Ghetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Tela - -->
<!-- Felipe Tadeu https://www.w3schools.com/bootstrap/bootstrap_grid_basic.asp // http://www.flextool.com.br/tabela_cores.html-->
<html lang="en">
    <head>
        <title>SVIM - Editar Funcionário</title>
        <link rel="shortcut icon" href="imagens/favicon.ico"/>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="editar_funcionario.js"></script>
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
                        <h1 class="txt">Editar Funcionário</h1>
                        <p class="txt">Selecione o seu funcionário a ser editado.</p>
                    </article>

                    <table class="table table-hover">
                        <thead>				
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>CPF</th>
                                <th>Data de Nascimento</th>
                                <th>Data de Admissão</th>
                                <th>Filial</th>
                                <th>Cargo</th>
                                <th>Senha</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Fulano</td>				        	
                                <td>000.000.000-00</td>				        	
                                <td>00/00/0000</td>				        	
                                <td>00/00/0000</td>				        	
                                <td>Filial - Avenida Filial</td>				        	
                                <td>Frentista</td>				        	
                                <td>******</td>				        	
                            </tr>
                        </tbody>
                    </table>

                    <br/>

                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Editar Selecionado</button>

                    <div class="modal fade" id="myModal" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Editar Funcionário</h4>
                                </div>

                                <div class="modal-body">
                                    <form>
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
                                                    <option value="frentista">Frentista</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="form-group col-md-8">
                                                <label for="filial">Filial:</label>
                                                <select name="filial" class="form-control">
                                                    <option value="exemplo">Filial - Avenida Filial</option>
                                                </select>
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="senha">Senha:</label>
                                                <input type="password" name="senha" class="form-control">
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
