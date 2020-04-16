package me.adrianoneres.command;

import me.adrianoneres.dao.LivroDao;
import me.adrianoneres.dao.ProdutoDuravelDao;
import me.adrianoneres.dao.ProdutoNaoDuravelDao;
import me.adrianoneres.model.Produto;
import me.adrianoneres.model.TipoProduto;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProdutoFiltrarCommand implements Command {

    @Inject
    private ProdutoDuravelDao produtoDuravelDao;

    @Inject
    private ProdutoNaoDuravelDao produtoNaoDuravelDao;

    @Inject
    private LivroDao livroDao;

    @Inject
    private ProdutoListarCommand produtoListarCommand;

    @Override
    public List<? extends Produto> executar(Properties properties) {
        String tipoProduto = properties.getProperty("tipoProduto");
        String nome = properties.getProperty("nome");

        boolean possuiTipoProduto = tipoProduto != null && !tipoProduto.trim().isEmpty();
        boolean possuiNome = nome != null && !nome.trim().isEmpty();
        boolean naoPossuiFiltro = !possuiTipoProduto && !possuiNome;

        if (naoPossuiFiltro) {
            return produtoListarCommand.executar(properties);
        }

        if (possuiTipoProduto) {
            return listarPorTipo(tipoProduto, nome);
        }

        return listarPorNome(nome);
    }

    private List<? extends Produto> listarPorTipo(String tipoProduto, String nome) {
        TipoProduto tipo = TipoProduto.valueOf(tipoProduto);

        if (TipoProduto.DURAVEL.equals(tipo)) {
            return produtoDuravelDao.listar(nome);
        }

        if (TipoProduto.NAO_DURAVEL.equals(tipo)) {
            return produtoNaoDuravelDao.listar(nome);
        }

        if (TipoProduto.LIVRO.equals(tipo)) {
            return livroDao.listar(nome);
        }

        return listarPorNome(nome);
    }

    private List<Produto> listarPorNome(String nome) {
        List<Produto> produtos = new ArrayList<>();

        produtos.addAll(produtoDuravelDao.listar(nome));
        produtos.addAll(produtoNaoDuravelDao.listar(nome));
        produtos.addAll(livroDao.listar(nome));

        return produtos;
    }
}
