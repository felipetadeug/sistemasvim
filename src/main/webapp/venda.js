window.addEventListener('load', function () {
    configurarItem(document.querySelector('.item'));
    
    document.querySelector('#adicionar_item').addEventListener('click',function(){
        
    });
});

function adicionarNovoItem(){
    
    
    
}



function configurarItem(item) {
    let comboTipo = item.querySelector('[name=tipo]')
    let comboProduto = item.querySelector('[name=produto]');
    let quantidade = item.querySelector('[name=quantidade]');
    let valor = item.querySelector('[name=valor]');

    adicionarTiposCombo(comboTipo);

    comboTipo.addEventListener('change', function (e) {
        adicionarProdutosCombo(comboProduto, e.target.value);
    });

    comboTipo.addEventListener('change', function (e) {
        valor.value = quantidade.value * precoProduto(comboProduto.value);
        atualizarValorTotal();
    });
    comboProduto.addEventListener('change', function (e) {
        valor.value = quantidade.value * precoProduto(comboProduto.value);
        atualizarValorTotal();
    });
    quantidade.addEventListener('change', function (e) {
        valor.value = quantidade.value * precoProduto(comboProduto.value);
        atualizarValorTotal();
    });
    quantidade.addEventListener('click', function (e) {
        valor.value = quantidade.value * precoProduto(comboProduto.value);
        atualizarValorTotal();
    });
    quantidade.addEventListener('keyup', function (e) {
        valor.value = quantidade.value * precoProduto(comboProduto.value);
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
    var result = $.grep(produtos, function (e) {
        return e.id == id;
    });
    if (result.length > 0) {
        return result[0].preco;
    }
    return 0;
}

function atualizarValorTotal(){
    let vlTotal = 0;
    document.querySelectorAll('[name=valor]').forEach(function(vl){
        vlTotal += parseFloat(vl.value);
    });
    document.querySelector('[name=total]').value = vlTotal;
}
