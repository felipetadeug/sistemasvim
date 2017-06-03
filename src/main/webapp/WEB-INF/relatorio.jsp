
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SVIM - Relatório</title>
        <link rel="shortcut icon" href="imagens/favicon.ico"/>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="relatorio.js"></script>
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
                        <h1 class="txt">Relatório</h1>
                        <p class="txt">Relatório de Vendas</p>
                    </article>
                    
                    <table class="table table-hover">
                        <thead>				
                            <tr>
                                <th>Data</th>
                                <th>Funcionario</th>
                                <th>Filial</th>
                                <th>Quantidade Itens</th>
                                <th>Valor Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="venda" items="${ListVenda}">
                                <tr>
                                    <td>${venda.getDataVenda()}</td>
                                    <td>${venda.getFuncionario().getNome()}</td>
                                    <td>${venda.getFilial().getNomeFilial()}</td>
                                    <td>${venda.getQuantidadeItens()}</td>
                                    <td>${venda.getValor()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <br/>
                   
                </section>
            </div>
        </div>
    </body>
</html>