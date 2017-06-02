<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SVIM - Venda</title>
        <link rel="shortcut icon" href="imagens/favicon.ico"/>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="venda.js"></script>
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
                        <h1 class="txt">Vendas</h1>
                        <p class="txt">Realize suas vendas.</p>
                    </article>

                    <form method="POST" action="./VendaCadastrar">
                        <div class="row well well-lg">

                            <div id="items">
                                <!-- TEMPLATE DE ITEM -->
                                <template id="template-item">
                                    <div class="item">
                                        <div class="form-group col-md-3">
                                            <label for="tipo">Tipo de Produto</label>
                                            <select name="tipo" class="form-control">
                                            </select>
                                        </div>	
                                        <div class="form-group col-md-3">
                                            <label for="produto">Produto</label>
                                            <select name="produto" class="form-control">
                                            </select>
                                        </div>		
                                        <div class="form-group col-md-2">
                                            <label for="quantidade">Quantidade</label>
                                            <input type="number" name="quantidade" min="0" value="0" class="form-control"/>
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="valor">Valor</label>
                                            <input type="text" name="valor" value="0" class="form-control" readonly/>
                                        </div>	
                                        <div class="form-group col-md-2">
                                            <label></label>
                                            <input type="button" name="remover" value="Remover" class="btn btn-block btn-danger"/>
                                        </div>
                                    </div>
                                </template>
                            </div>

                            <div class="pull-right col-md-2">
                                <input id="adicionar_item" value="Adicionar Produto" class="btn btn-block btn-info"/>
                            </div>    
                            <div class="col-md-2">
                                <label>Total: R$ <span id="vltotal">0.00</span></label>				
                            </div>
                        </div>                        

                        <div class="row">
                            <div class="col-md-2">
                                <label></label>
                                <button type="submit" class="btn btn-success">Finalizar Compra</button>
                            </div>
                        </div>      
                    </form>
                </section>
            </div>
        </div>

        <script type="text/javascript">
            var produtos = [];
            var tipos_produto = [];

            <c:forEach var="produto" items="${ListProduto}">
            produto = {};
            produto.id = ${produto.getIdProduto()};
            produto.produto = '${produto.getProduto()}';
            produto.id_tipo_produto = ${produto.getTipoProduto().getIdTipoProduto()};
            produto.tipo_produto = '${produto.getTipoProduto().getTipoProduto()}';
            produto.preco = ${produto.getPreco()};
            produto.combustivel = ${produto.isCombustivel()};
            produto.estocavel = ${produto.isEstocavel()};
            produtos.push(produto);
            </c:forEach>

            <c:forEach var="tipo" items="${ListTipoProduto}">
            tipo = {};
            tipo.id = ${tipo.getIdTipoProduto()};
            tipo.tipo = '${tipo.getTipoProduto()}';
            tipos_produto.push(tipo);
            </c:forEach>

        </script>

    </body>
</html>