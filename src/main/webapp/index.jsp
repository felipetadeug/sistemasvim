<%-- 
    Document   : index
    Created on : 16/04/2017, 19:24:35
    Author     : Cauê Ghetti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>SVIM</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<meta charset="utf-8">
</head>
<body>
	<section>
		<article class="nav">
			<ul>
				<li>Sobre</li>
				<li>Login</li>
			</ul>
		</article>
		
		<article class="home">
			<div class="divisao um">
				<h1>Bem vindo à<br> Astec Gestão de Filiais</h1>
				
				<p>Controle suas filiais, usuários, produtos e serviços em um só local. Saiba quantos itens foram vendidos em um intervalo de
				tempo com a opção de Relatórios e efetue Vendas</p>

				<div class="botao">
					<P>Sobre</P>
				</div>
			</div>

			<div class="divisao dois">
				<div class="box_login">\ 
					<div class="descricao_login">
						<h1>Login to Astec</h1>
						<p>Entre com seu usuário e senha para efetuar o Login</p>
					</div>				
					
					<div class="form_login">
						<form action="./Autenticar">
							<input type="text" name="usuario" placeholder="Usuário">
							<input type="password" name="senha" placeholder="Senha">
							<button>Login</button>
						</form>
					</div>
				</div>				
			</div>
		</article>

		<article class="sobre">
			<div class="titulo">
				<h1>Serviços</h1>

				<ul>
					<li>teste</li>
					<li>teste2</li>
				</ul>
			</div>	

			<div>
				<img src="imagens\icone_cadastro.png">
				<h3>Cadastros</h3>
				<p>Controle o cadastro de filiais, itens e usuarios.</p>
			</div>

			<div>
				<img src="imagens\icone_vendas.png">
				<h3>Vendas</h3>
				<p>Realize e armazene os dados de suas vendas.</p>
			</div>

			<div>
				<img src="imagens\icone_relatorio.png">
				<h3>Relatórios</h3>
				<p>Gerencie suas vendas com relatórios por período.</p>
			</div>


		</article>
	</section>
</body>
</html>