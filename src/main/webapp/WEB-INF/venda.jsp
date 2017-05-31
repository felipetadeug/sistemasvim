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
			<div class="col-md-12">
				<h1>SVIM</h1>
			</div>		
		</header>

		<div class="row">			
			<aside class="col-md-2" id="menu">
				<h1>Operações</h1>

				<ul>
					<li><a href="venda.html">Venda</a></li>

					<li>Itens</li>
					<ul>
						<li><a href="cadastrar_item.html">Novo Cadastro</a></li>
						<li><a href="editar_item.html">Alterar Cadastro</a></li>
					</ul>

					<li>Funcionarios</li>
					<ul>
						<li><a href="cadastrar_funcionario.html">Novo Cadastro</a></li>
						<li><a href="editar_funcionario.html">Alterar Cadastro</a></li>
					</ul>

					<li>Filiais</li>
					<ul>
						<li><a href="cadastrar_filial.html">Novo Cadastro</a></li>
						<li><a href="editar_filial.html">Alterar Cadastro</a></li>
					</ul>

					<li><a href="estoque.html">Estoque</a></li>
					<li><a href="relatorio.html">Relatórios</a></li>
					<li><a href="parametros.html">Parâmetros</a></li>
				</ul>
			</aside>

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

		<footer class="row" id="rodape">
			<div class="col-md-12">
				<p>Sistema SVIM -  Todos os direitos reservados ®</p>
			</div>			
		</footer>
	</div>
</body>
</html>