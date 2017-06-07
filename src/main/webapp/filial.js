    // instancia um objeto vazio para usar como filial (filial selecionada)
    var filial = {};

window.addEventListener('load', function () {

    // se houver erro na tela, mostra o modal
    if ($('#msgErro').text().trim()) {
        $('#errorModal').modal('show');
    }

    // tabela com paginacao e busca
    $('table').DataTable();

    // ao clicar no botao de EDITAR (abrir modal)
    $('button[data-target="#editarFilial"]').click(function () {
        if ($('tr.selected').length == 0) {
            alert('selecione um registro');
            return false;
        }

        // envia os dados pros campos da modal
        $('#editarFilial [name=id]').val(filial.id);
        $('#editarFilial [name=nome]').val(filial.nome);
        $('#editarFilial [name=cep]').val(filial.cep);
        $('#editarFilial [name=endereco]').val(filial.endereco);
        $('#editarFilial [name=numero]').val(filial.numero);
        $('#editarFilial [name=bairro]').val(filial.bairro);
        $('#editarFilial [name=cidade]').val(filial.cidade);
        $('#editarFilial [name=uf]').val(filial.uf);
    });

    // ao clicar no botao de DELETAR (abrir modal)
    $('button[data-target="#deletarFilial"]').click(function () {
        if ($('tr.selected').length == 0) {
            alert('selecione um registro');
            return false;
        }

        // envia os dados pros campos da modal
        $('#deletarFilial [name=id]').val(filial.id);
    });

});

// ao clicar em uma linha da tabela
$(document).on('click', ".table tr", function () {
    // adiciona a classe selected na linha e remove da antiga
    $(this).addClass('selected').siblings().removeClass('selected');

    // obtem os dados contidos em cada coluna e preenche o objeto
    filial.id = $(this).find('td:nth-child(1)').html();
    filial.nome = $(this).find('td:nth-child(2)').html();
    filial.cep = $(this).find('td:nth-child(3)').html();
    filial.endereco = $(this).find('td:nth-child(4)').html();
    filial.numero = $(this).find('td:nth-child(5)').html();
    filial.bairro = $(this).find('td:nth-child(6)').html();
    filial.cidade = $(this).find('td:nth-child(7)').html();
    filial.uf = $(this).find('td:nth-child(8)').html();
});
