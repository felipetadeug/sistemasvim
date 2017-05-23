<%-- 
    Document   : cadastrar_filial
    Created on : 16/05/2017, 14:51:06
    Author     : Cauê Ghetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Tela - Cadastrar Filial-->
<!-- Felipe Tadeu -->
<html lang="en">
    <head>
        <title>SVIM - Cadastrar Filial</title>
        <link rel="shortcut icon" href="imagens/favicon.ico"/>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="/style.css">
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
                        <h1 class="txt">Cadastrar Filial</h1>
                        <p class="txt">Insira os dados de sua filial.</p>
                    </article>

                    <form method="POST" action="./FilialCadastrar">
                        <div class="row">
                            <div class="form-group col-md-10">
                                <label for="nome">Nome:</label>
                                <input type="text" name="nome" class="form-control" required>
                            </div>

                            <div class="form-group col-md-2">
                                <label for="cep">CEP:</label>
                                <input type="text" name="cep" class="form-control" required>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-10">
                                <label for="endereco">Endereço:</label>
                                <input type="text" name="endereco" class="form-control" required>
                            </div>

                            <div class="form-group col-md-2">
                                <label for="numero">Número:</label>
                                <input type="text" name="numero" class="form-control" required>
                            </div>						
                        </div>

                        <div class="row">
                            <div class="form-group col-md-5">
                                <label for="bairro">Bairro:</label>
                                <input type="text" name="bairro" class="form-control" required>
                            </div>

                            <div class="form-group col-md-5">
                                <label for="cidade">Cidade:</label>
                                <input type="text" name="cidade" class="form-control" required>
                            </div>

                            <div class="form-group col-md-2">
                                <label for="uf">UF:</label>
                                <select name="uf" class="form-control">
                                    <option value="SP">SP</option> 
                                    <!-- Script para carregar valores. -->
                                </select>
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
