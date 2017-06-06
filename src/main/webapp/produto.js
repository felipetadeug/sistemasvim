window.addEventListener('load', function () {

    // se houver erro na tela, mostra o modal
    if ($('#msgErro').text().trim()) {
        $('#errorModal').modal('show');
    }

    // tabela com paginacao e busca
    $('table').DataTable();

    // instancia um objeto vazio para usar como produto (produto selecionada)
    var produto = {};

    // ao clicar em uma linha da tabela
    $('.table tr').click(function () {
        // adiciona a classe selected na linha e remove da antiga
        $(this).addClass('selected').siblings().removeClass('selected');

        // obtem os dados contidos em cada coluna e preenche o objeto
        produto.id = $(this).find('td:nth-child(1)').html();
        produto.produto = $(this).find('td:nth-child(2)').html();
        produto.id_tipo_produto = $(this).find('td:nth-child(3)').html();
        produto.tipo_produto = $(this).find('td:nth-child(4)').html();
        produto.preco = $(this).find('td:nth-child(5)').html();
        produto.combustivel = $(this).find('td:nth-child(6)').html() == 'true';
        produto.estocavel = $(this).find('td:nth-child(7)').html() == 'true';

    });

    // ao clicar no botao de EDITAR (abrir modal)
    $('button[data-target="#editarProduto"]').click(function () {
        if ($('tr.selected').length == 0) {
            alert('selecione um registro');
            return false;
        }

        // envia os dados pros campos da modal
        $('#editarProduto [name=id]').val(produto.id);
        $('#editarProduto [name=produto]').val(produto.produto);
        $('#editarProduto [name=preco]').val(produto.preco);
        $('#editarProduto [name=tipo_produto]').val(produto.id_tipo_produto);            
        $('#editarProduto [name=combustivel]').prop('checked',produto.combustivel);
        $('#editarProduto [name=estocavel]').prop('checked',produto.estocavel);
    });

    // ao clicar no botao de DELETAR (abrir modal)
    $('button[data-target="#deletarProduto"]').click(function () {
        if ($('tr.selected').length == 0) {
            alert('selecione um registro');
            return false;
        }

        // envia os dados pros campos da modal
        $('#deletarProduto [name=id]').val(produto.id);
    });

});