window.addEventListener('load', function () {

    // se houver erro na tela, mostra o modal
    if ($('#msgErro').text().trim()) {
        $('#errorModal').modal('show');
    }

    // tabela com paginacao e busca
    $('table').DataTable();

    // instancia um objeto vazio para usar como cargo (cargo selecionada)
    var cargo = {};

    // ao clicar em uma linha da tabela
    $('.table tr').click(function () {
        // adiciona a classe selected na linha e remove da antiga
        $(this).addClass('selected').siblings().removeClass('selected');

        // obtem os dados contidos em cada coluna e preenche o objeto
        cargo.id = $(this).find('td:nth-child(1)').html();
        cargo.cargo = $(this).find('td:nth-child(2)').html();
        cargo.hierarquia = $(this).find('td:nth-child(3)').html();

    });

    // ao clicar no botao de EDITAR (abrir modal)
    $('button[data-target="#editarCargo"]').click(function () {
        if ($('tr.selected').length == 0) {
            alert('selecione um registro');
            return false;
        }

        // envia os dados pros campos da modal
        $('#editarCargo [name=id]').val(cargo.id);
        $('#editarCargo [name=cargo]').val(cargo.cargo);
        $('#editarCargo [name=hierarquia]').val(cargo.hierarquia);
    });

    // ao clicar no botao de DELETAR (abrir modal)
    $('button[data-target="#deletarCargo"]').click(function () {
        if ($('tr.selected').length == 0) {
            alert('selecione um registro');
            return false;
        }

        // envia os dados pros campos da modal
        $('#deletarCargo [name=id]').val(cargo.id);
    });

});



