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

    // ao clicar em uma linha da tabela
    $('.table tr').click(function () {

        // obtem o id da venda para buscar
        var id = $(this).find('td:nth-child(1)').html();

        // faz a requisicao
        fetch("/sistemasvim/RelatorioDetalhe?id=" + id)
                .then(function (res) {
                    return res.json();
                })
                .then(function (data) {
                    PopularDetalheVenda(data);
                });
    });
});

function PopularDetalheVenda(venda) {
    // popula a modal
    var body = $('#modalDetalhe .modal-body');
    
    body.empty();

    body.append('<p><b>ID Venda</b>: ' + venda.idVenda + '</p>');
    body.append('<p><b>Data</b>: ' + venda.dataVenda + '</p>');
    body.append('<p><b>Funcionario</b>: ' + venda.funcionario.nome + '</p>');
    body.append('<p><b>Filial</b>: ' + venda.filial.nomeFilial + '</p>');
    body.append('<p><b>Itens</b>:</p>');
    var items = body.append('<ul></ul>');

    let qtdItens = 0;
    let vlTotal = 0;

    venda.items.forEach(function (item) {
        qtdItens += item.quantidade;
        vlTotal += (item.produto.preco * item.quantidade);

        items.append('<li>' + item.quantidade + ' '
                + item.produto.produto + ', R$ '
                + item.produto.preco.toFixed(2) + '</li>');
    });
    
    body.append('<br>');
    body.append('<p><b>Qtd Total</b>: ' + qtdItens + '</p>');
    body.append('<p><b>Vlr Total</b>: R$ ' + vlTotal.toFixed(2) + '</p>');
    // abre modal        
    $('#modalDetalhe').modal('show');
}