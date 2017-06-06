window.addEventListener('load', function () {

    // se houver erro na tela, mostra o modal
    if ($('#msgErro').text().trim()) {
        $('#errorModal').modal('show');
    }

    // tabela com paginacao e busca
    $('table').DataTable();
    
    // formatacao de data
    $(".dtpicker").datepicker({ 
        format: 'yyyy-mm-dd'
    });
});