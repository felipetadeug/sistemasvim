/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load',function(){
	
	// ao clicar em uma linha da tabela
	$('.table tr').click(function(){
		// adiciona a classe selected na linha e remove da antiga
		$(this).addClass('selected').siblings().removeClass('selected');

		// instancia um objeto vazio para usar como filial
		let filial = {};
		
		// obtem os dados contidos em cada coluna e preenche o objeto
                filial.id = $(this).find('td:nth-child(1)').html();
		filial.nome = $(this).find('td:nth-child(2)').html();
		filial.cep = $(this).find('td:nth-child(3)').html();
		filial.endereco = $(this).find('td:nth-child(4)').html();
		filial.numero = $(this).find('td:nth-child(5)').html();
		filial.bairro = $(this).find('td:nth-child(6)').html();
		filial.cidade = $(this).find('td:nth-child(7)').html();
		filial.uf = $(this).find('td:nth-child(8)').html();
		
		// envia os dados pros campos da modal
                $('.modal [name=id]').val(filial.id);
		$('.modal [name=nome]').val(filial.nome);
		$('.modal [name=cep]').val(filial.cep);
		$('.modal [name=endereco]').val(filial.endereco);
		$('.modal [name=numero]').val(filial.numero);
		$('.modal [name=bairro]').val(filial.bairro);
		$('.modal [name=cidade]').val(filial.cidade);
		$('.modal [name=uf]').val(filial.uf);
		
	});
	
	// ao clicar no botao de editar (abrir modal)
	$('button[data-toggle=modal]').click(function(){
		if($('tr.selected').length == 0){
			alert('selecione um registro');
			return false;
		}			
	});
});

