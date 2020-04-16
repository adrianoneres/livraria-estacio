var inputDataVencimento = document.getElementById('form-group-data-vencimento');
var inputAutor = document.getElementById('form-group-autor');

function atribuirEventos() {
    mostrarInputPorTipo('NAO_DURAVEL', inputDataVencimento);
    mostrarInputPorTipo('LIVRO', inputAutor);
}

function mostrarInputPorTipo(tipoProduto, input) {
    const radiosTipoProduto = document.getElementsByName("tipoProduto");
    radiosTipoProduto.forEach(radio => radio.addEventListener('change', function () {
        if (this.value === tipoProduto) {
            input.classList.remove('d-none');
        } else {
            input.classList.add('d-none')
        }
    }));
}

atribuirEventos();