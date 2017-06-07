    // instancia um objeto vazio para usar como tipo (tipo selecionada)
    var tipo = {};

window.addEventListener('load', function () {

    // se houver erro na tela, mostra o modal
    if ($('#msgErro').text().trim()) {
        $('#errorModal').modal('show');
    }

    // tabela com paginacao e busca
    $('table').DataTable();

    // ao clicar no botao de EDITAR (abrir modal)
    $('button[data-target="#editarTipoProduto"]').click(function () {
        if ($('tr.selected').length == 0) {
            alert('selecione um registro');
            return false;
        }

        // envia os dados pros campos da modal
        $('#editarTipoProduto [name=id]').val(tipo.id);
        $('#editarTipoProduto [name=tipo]').val(tipo.tipo);
    });

    // ao clicar no botao de DELETAR (abrir modal)
    $('button[data-target="#deletarTipoProduto"]').click(function () {
        if ($('tr.selected').length == 0) {
            alert('selecione um registro');
            return false;
        }

        // envia os dados pros campos da modal
        $('#deletarTipoProduto [name=id]').val(tipo.id);
    });

});


// ao clicar em uma linha da tabela
$(document).on('click', ".table tr", function () {

    // adiciona a classe selected na linha e remove da antiga
    $(this).addClass('selected').siblings().removeClass('selected');

    // obtem os dados contidos em cada coluna e preenche o objeto
    tipo.id = $(this).find('td:nth-child(1)').html();
    tipo.tipo = $(this).find('td:nth-child(2)').html();

});

