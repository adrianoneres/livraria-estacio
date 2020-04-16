package me.adrianoneres.command;

import me.adrianoneres.dao.LivroDao;
import me.adrianoneres.dao.ProdutoDuravelDao;
import me.adrianoneres.dao.ProdutoNaoDuravelDao;
import me.adrianoneres.model.Produto;
import me.adrianoneres.model.TipoProduto;

import javax.inject.Inject;
import java.util.Properties;

public class ProdutoExcluirCommand implements Command {

    @Inject
    private ProdutoBuscarCommand produtoBuscarCommand;

    @Inject
    private ProdutoDuravelDao produtoDuravelDao;

    @Inject
    private ProdutoNaoDuravelDao produtoNaoDuravelDao;

    @Inject
    private LivroDao livroDao;

    @Override
    public Boolean executar(Properties properties) {
        Produto produto = produtoBuscarCommand.executar(properties);
        TipoProduto tipoProduto = TipoProduto.valueOf(properties.getProperty("tipoProduto"));

        if (TipoProduto.DURAVEL.equals(tipoProduto)) {
            return excluirProdutoDuravel(produto.getId());
        }

        if (TipoProduto.NAO_DURAVEL.equals(tipoProduto)) {
            return excluirProdutoNaoDuravel(produto.getId());
        }

        return excluirLivro(produto.getId());
    }

    private Boolean excluirProdutoDuravel(Long id) {
        produtoDuravelDao.excluir(id);
        return true;
    }

    private Boolean excluirProdutoNaoDuravel(Long id) {
        produtoNaoDuravelDao.excluir(id);
        return true;
    }

    private Boolean excluirLivro(Long id) {
        livroDao.excluir(id);
        return true;
    }
}
