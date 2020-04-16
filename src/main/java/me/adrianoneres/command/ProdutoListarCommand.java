package me.adrianoneres.command;

import me.adrianoneres.dao.LivroDao;
import me.adrianoneres.dao.ProdutoDuravelDao;
import me.adrianoneres.dao.ProdutoNaoDuravelDao;
import me.adrianoneres.model.Produto;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProdutoListarCommand implements Command {

    @Inject
    private ProdutoDuravelDao produtoDuravelDao;

    @Inject
    private ProdutoNaoDuravelDao produtoNaoDuravelDao;

    @Inject
    private LivroDao livroDao;

    @Override
    public List<Produto> executar(Properties properties) {
        List<Produto> produtos = new ArrayList<>();

        produtos.addAll(produtoDuravelDao.listar());
        produtos.addAll(produtoNaoDuravelDao.listar());
        produtos.addAll(livroDao.listar());

        return produtos;
    }
}
