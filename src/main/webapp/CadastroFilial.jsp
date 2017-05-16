<%-- 
    Document   : CadastroFilial
    Created on : 18/04/2017, 11:42:38
    Author     : Cauê Ghetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Tela - Cadastrar Filial-->
<!-- Felipe Tadeu https://www.w3schools.com/bootstrap/bootstrap_grid_basic.asp // http://www.flextool.com.br/tabela_cores.html-->
<html lang="en">
<head>
	<title>SVIM - Cadastrar Filial</title>
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
			<div class="col-md-10">
				<h1>SVIM</h1>
			</div>		
			<div class="col-md-2 saudacao"> 
				<span class="glyphicon glyphicon-user">Olá Fulano</span>
			</div>		
		</header>

		<div class="row">			
			<aside class="col-md-2" id="menu">

				<h1>Operações</h1>

				<ul>
					<li><a href="venda.html">Realizar Venda</a></li>

					<li><a href="">Cadastrar Itens</a></li>
					<ul>
						<li><a href="#">Novo Cadastro</a></li>
						<li><a href="#">Alterar Cadastro</a></li>
					</ul>

					<li><a href="">Cadastrar Usuarios</a></li>
					<ul>
						<li><a href="#">Novo Cadastro</a></li>
						<li><a href="#">Alterar Cadastro</a></li>
					</ul>

					<li><a href="">Cadastrar Filiais</a></li>
					<ul>
						<li><a href="#">Novo Cadastro</a></li>
						<li><a href="./FilialListar">Alterar Cadastro</a></li>
					</ul>

					<li><a href="#">Estoque</a></li>
					<li><a href="#">Relatórios</a></li>
					</ul>
			</aside>

			<section class="col-md-10" id="principal">
				<article class="descricao page-header">
					<h1>Cadastrar Filial</h1>
					<p>Insira os dados de sua filial.</p>
				</article>

				<form class="well well-lg" method="post" action="./FilialCadastrar">
					<div class="row">
						<div class="form-group col-md-10">
							<label for="nome">Nome:</label>
							<input type="nome" name="FilialNome" class="form-control" >
						</div>

						<div class="form-group col-md-2">
							<label for="cep">CEP:</label>
							<input type="text" name="FilialCEP" class="form-control">
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-10">
							<label for="endereco">Endereço:</label>
							<input type="text" name="FilialRua" class="form-control">
						</div>

						<div class="form-group col-md-2">
							<label for="numero">Número:</label>
							<input type="text" name="FilialNumero" class="form-control">
						</div>						
					</div>

					<div class="row">
						<div class="form-group col-md-5">
							<label for="bairro">Bairro:</label>
							<input type="text" name="FilialBairro" class="form-control">
						</div>

						<div class="form-group col-md-5">
							<label for="cidade">Cidade:</label>
							<input type="text" name="FilialCidade" class="form-control">
						</div>

						<div class="form-group col-md-2">
							<label for="uf">UF:</label>
							<select name="FilialUF" class="form-control">
								<option value="SP">SP</option>
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