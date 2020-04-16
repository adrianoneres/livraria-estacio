package me.adrianoneres.model;

public enum TipoProduto {
    DURAVEL("Durável"),
    NAO_DURAVEL("Não durável"),
    LIVRO("Livro");

    private String descricao;

    private TipoProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
