/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', function () {
// ao clicar em uma linha da tabela
    $('.table tr').click(function () {
// adiciona a classe selected na linha e remove da antiga
        $(this).addClass('selected').siblings().removeClass('selected');

// instancia um objeto vazio para usar como cargo
        let cargo = {};
// obtem os dados contidos em cada coluna e preenche o objeto
        cargo.id = $(this).find('td:nth-child(1)').html();
        cargo.nome = $(this).find('td:nth-child(2)').html();
// envia os dados pros campos da modal
        $('.modal [name=id]').val(cargo.id);
        $('.modal [name=nome]').val(cargo.nome);
    });
// ao clicar no botao de editar (abrir modal)
    $('button[data-toggle=modal]').click(function () {
        if ($('tr.selected').length == 0) {
            alert('selecione um registro');
            return false;
        }
    });
});

