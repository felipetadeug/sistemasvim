window.addEventListener('load', function () {

    // instancia um objeto vazio para usar como funcionario (funcionario selecionada)
    var funcionario = {};

    // ao clicar em uma linha da tabela
    $('.table tr').click(function () {
        // adiciona a classe selected na linha e remove da antiga
        $(this).addClass('selected').siblings().removeClass('selected');

        // obtem os dados contidos em cada coluna e preenche o objeto
        funcionario.id = $(this).find('td:nth-child(1)').html();
        funcionario.nome = $(this).find('td:nth-child(2)').html();
        funcionario.cpf = $(this).find('td:nth-child(3)').html();
        funcionario.dtnasc = $(this).find('td:nth-child(4)').html();
        funcionario.dtadm = $(this).find('td:nth-child(5)').html();
        funcionario.id_cargo = $(this).find('td:nth-child(6)').html();
        funcionario.cargo = $(this).find('td:nth-child(7)').html();
        funcionario.id_filial = $(this).find('td:nth-child(8)').html();
        funcionario.filial = $(this).find('td:nth-child(9)').html();
        funcionario.senha = $(this).find('td:nth-child(10)').html();

    });

    // ao clicar no botao de EDITAR (abrir modal)
    $('button[data-target="#editarFuncionario"]').click(function () {
        if ($('tr.selected').length == 0) {
            alert('selecione um registro');
            return false;
        }

        // envia os dados pros campos da modal
        $('#editarFuncionario [name=id]').val(funcionario.id);
        $('#editarFuncionario [name=nome]').val(funcionario.nome);
        $('#editarFuncionario [name=cpf]').val(funcionario.cpf);
        $('#editarFuncionario [name=dtnasc]').val(funcionario.dtnasc);
        $('#editarFuncionario [name=dtadm]').val(funcionario.dtadm);
        $('#editarFuncionario [name=cargo]').val(funcionario.id_cargo);
        $('#editarFuncionario [name=filial]').val(funcionario.id_filial);
        $('#editarFuncionario [name=senha]').val(funcionario.senha);
    });
    
    // ao clicar no botao de DELETAR (abrir modal)
    $('button[data-target="#deletarFuncionario"]').click(function () {   
        if ($('tr.selected').length == 0) {
            alert('selecione um registro');
            return false;
        }

        // envia os dados pros campos da modal
        $('#deletarFuncionario [name=id]').val(funcionario.id);
    });
     
});



