<%-- 
    Document   : cadastrar_item
    Created on : 16/05/2017, 17:12:03
    Author     : Cauê Ghetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <title>SVIM - Cadastrar Itens</title>
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
                        <li><a href="./FilialListar">Alterar Cadastro - Filial</a></li>


                        <li><a href="">Estoque</a></li>
                        <li><a href="">Relatórios</a></li>
                        <li><a href="venda.jsp">Venda</a></li>
                        <li><a href="./CargoListar">Parâmetros</a></li>
                    </ul>
                </aside>

                <section class="col-md-10" id="principal">
                    <article class="page-header">
                        <h1 class="txt">Cadastrar Itens</h1>
                        <p class="txt">Insira os dados de seus itens.</p>
                    </article>

                    <form class="well well-lg">
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="descricao">Descrição:</label>
                                <input type="text" name="descricao" class="form-control" >
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-3">
                                <label for="valor">Valor:</label>
                                <input type="text" name="valor" class="form-control">
                            </div>

                            <div class="form-group col-md-3">
                                <label for="tipo">Tipo:</label>
                                <select name="tipo" class="form-control">
                                    <option value="combustivel">Combustivel</option>
                                    <option value="produto">Produto</option>
                                    <option value="servico">Serviço</option>
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