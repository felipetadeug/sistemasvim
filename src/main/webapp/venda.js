window.addEventListener('load', function () {
    // armazena em variavel o template de item (para quando precisar adicionar)
    var template = document.querySelector('#template-item');

    // ao clicar em adicionar novo produto, adiciona um novo item na tela
    document.querySelector('#adicionar_item').addEventListener('click', function () {
        adicionarNovoItem(template);
    });

    // adiciona o primeiro item
    adicionarNovoItem(template);
});

function adicionarNovoItem(template) {
    let clone = document.importNode(template.content, true);
    document.querySelector('#items').appendChild(clone);
    let item = document.querySelector('.item:last-child');
    configurarItem(item);
}

function configurarItem(item) {
    // armazena os combos e produto e tipo
    let comboTipo = item.querySelector('[name=tipo]');
    let comboProduto = item.querySelector('[name=produto]');
    let quantidade = item.querySelector('[name=quantidade]');
    let remover = item.querySelector('[name=remover]');

    // adiciona os tipos no combo de tipo
    adicionarTiposCombo(comboTipo);

    // ao selecionar tipo adiciona os produtos no combo de produtos
    comboTipo.addEventListener('change', function (e) {
        adicionarProdutosCombo(comboProduto, e.target.value);
    });

    // ao clicar em remover item
    remover.addEventListener('click', function (e) {
        item.parentNode.removeChild(item);
        atualizarValorTotal();
    });

    // eventos para atualizar valor do item e valor total da compra
    comboTipo.addEventListener('change', function (e) {
        atualizarValorItem(item);
        atualizarValorTotal();
    });
    comboProduto.addEventListener('change', function (e) {
        atualizarValorItem(item);
        atualizarValorTotal();
    });
    quantidade.addEventListener('change', function (e) {
        atualizarValorItem(item);
        atualizarValorTotal();
    });
    quantidade.addEventListener('click', function (e) {
        atualizarValorItem(item);
        atualizarValorTotal();
    });
    quantidade.addEventListener('keyup', function (e) {
        atualizarValorItem(item);
        atualizarValorTotal();
    });
}

function adicionarTiposCombo(combo) {
    let o = document.createElement("option");
    o.value = 0;
    o.innerText = 'Selecione';
    combo.appendChild(o);
    tipos_produto.forEach(function (tipo) {
        let o = document.createElement("option");
        o.value = tipo.id;
        o.innerText = tipo.tipo;
        combo.appendChild(o);
    });
}

function adicionarProdutosCombo(combo, tipo) {
    combo.innerHTML = '';
    let o = document.createElement("option");
    o.value = 0;
    o.innerText = 'Selecione';
    combo.appendChild(o);
    produtos.forEach(function (produto) {
        if (produto.id_tipo_produto == tipo) {
            let o = document.createElement("option");
            o.value = produto.id;
            o.innerText = produto.produto;
            combo.appendChild(o);
        }
    });
}

function precoProduto(id) {
    let result = $.grep(produtos, function (e) {
        return e.id == id;
    });
    if (result.length > 0) {
        return result[0].preco;
    }
    return 0;
}

function atualizarValorItem(item) {
    let txt_valor = item.querySelector('[name=valor]');
    let comboProduto = item.querySelector('[name=produto]');
    let quantidade = item.querySelector('[name=quantidade]').value;
    let valor = precoProduto(comboProduto.value);

    txt_valor.value = (quantidade * valor).toFixed(2);
}

function atualizarValorTotal() {
    let vlTotal = 0;
    document.querySelectorAll('[name=valor]').forEach(function (vl) {
        vlTotal += parseFloat(vl.value);
    });
    document.querySelector('#vltotal').innerText = vlTotal.toFixed(2);
}
