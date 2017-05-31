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

                    <form class="well well-lg">
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="tipo">Tipo</label>
                                <select name="tipo" class="form-control">
                                    <option value="combustivel">Combustivel</option>
                                    <option value="produto">Produto</option>
                                    <option value="servico">Serviço</option>
                                </select>
                            </div>	

                            <div class="form-group col-md-8">
                                <label for="item">Item</label>
                                <select name=item class="form-control">
                                    <option value="gasolina adtivada v-power">Gasolina Adtivada - VPower</option>
                                </select>
                            </div>		
                        </div>	

                        <div class="row">
                            <div class="form-group col-md-3">
                                <label for="quantidade">Quantidade</label>
                                <input type="text" name="quantidade" class="form-control">
                            </div>

                            <div class="form-group col-md-3">
                                <label for="valor">Valor</label>
                                <input type="text" name="valor" class="form-control">
                            </div>					
                        </div>

                        <a href="#">Adcicionar novo</a>
                    </form>

                    <div class="row">
                        <div class="form-group col-md-3">
                            <label for="total">Total:</label>
                            <input type="text" name="total" class="form-control">					
                        </div>
                    </div>

                    <br />

                    <div class="row">
                        <div class="form-group col-md-3">
                            <button type="submit" class="btn btn-success">Finalizar Compra</button>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>