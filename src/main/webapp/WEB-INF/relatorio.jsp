
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="relatorio.js"></script>

    </head>
    <body>
         <div class="container-fluid">
            <header class="row" id="superior">
                <div class="container-fluid"  style="background-color:hsla(190, 100%, 35%, 1);color:#fff;height:100px;">
                    <h1>SVIM</h1>
                    <div class="pull-right" ><a href="./Sair" class="linkColor"> Sair</a></div>
                    <p>Seja bem vindo.</p>
                </div>			
            </header>
            <br>

            <div class="row">			

                <ul class="col-md-2 nav nav-pills nav-stacked">                  
                    <c:choose>
                        <c:when test="${sessionScope.funcionario.cargo.hierarquia gt 2}">
                            <li class="active"><a href="#">Operações</a></li>
                            <li><a href="./VendaListar">Venda</a></li>
                            <li><a href="./Relatorio">Relatório</a></li>
                            <li><a href="./FilialListar">Filial</a></li>
                            <li><a href="./CargoListar">Cargo</a></li>
                            <li><a href="./FuncionarioListar">Funcionario</a></li>                      
                            <li><a href="./ProdutoListar">Produto</a></li>
                            <li><a href="./TipoProdutoListar">Tipo de Produto</a></li>
                            </c:when>
                            <c:when test="${sessionScope.funcionario.cargo.hierarquia gt 1}">
                            <li class="active"><a href="#">Operações</a></li>
                            <li><a href="./VendaListar">Venda</a></li>
                            <li><a href="./Relatorio">Relatório</a></li>
                            <li><a href="./CargoListar">Cargo</a></li>
                            <li><a href="./FuncionarioListar">Funcionario</a></li>                      
                            <li><a href="./ProdutoListar">Produto</a></li>
                            <li><a href="./TipoProdutoListar">Tipo de Produto</a></li>
                            </c:when>
                            <c:otherwise>
                            <li><a href="./VendaListar">Venda</a></li>
                            </c:otherwise>
                        </c:choose>
                </ul>

                <section class="col-md-10" id="principal">
                    <article class="page-header">
                        <h1 class="txt">Relatório</h1>
                        <p class="txt">Relatório de Vendas</p>
                    </article>

                    <div class="row">
                        <form method="GET" action="./Relatorio">
                            <div class="form-group col-md-3">
                                <label for="dtini">De:</label>
                                <input type="text" name="dtini" placeholder="yyyy-mm-dd" class="form-control dtpicker" required/>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="dtfim">Até:</label>
                                <input type="text" name="dtfim" placeholder="yyyy-mm-dd" class="form-control dtpicker" required/>
                            </div>
                            <div>
                                <br>
                                <button type="submit" class="btn btn-primary">Consultar</button>
                            </div>

                        </form>             
                    </div>

                    <table class="table table-hover">
                        <thead>				
                            <tr>
                                <th>ID</th>
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
                                    <td>${venda.getIdVenda()}</td>
                                    <td>${venda.getDataVenda()}</td>
                                    <td>${venda.getFuncionario().getNome()}</td>
                                    <td>${venda.getFilial().getNomeFilial()}</td>
                                    <td>${venda.getQuantidadeItens()}</td>
                                    <td>R$ <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${venda.getValor()}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <!-- Modal - ERRO -->                    
                    <div class="modal fade" id="errorModal" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">ERRO!</h4>
                                </div>
                                <div class="modal-body">
                                    <h4 id="msgErro">
                                        <c:if test="${not empty msg}">
                                            ${msg}
                                        </c:if>
                                    </h4>
                                </div>
                            </div>				      
                        </div>
                    </div> 

                    <!-- Modal - DETALHE -->                    
                    <div class="modal fade" id="modalDetalhe" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Detalhes da Venda</h4>
                                </div>
                                <div class="modal-body">

                                </div>
                            </div>				      
                        </div>
                    </div>


                </section>
            </div>
        </div>
    </body>
</html>