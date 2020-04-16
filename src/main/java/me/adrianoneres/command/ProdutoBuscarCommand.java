package me.adrianoneres.command;

import me.adrianoneres.dao.LivroDao;
import me.adrianoneres.dao.ProdutoDuravelDao;
import me.adrianoneres.dao.ProdutoNaoDuravelDao;
import me.adrianoneres.model.Produto;

import javax.inject.Inject;
import java.util.Properties;

public class ProdutoBuscarCommand implements Command {

    @Inject
    private ProdutoDuravelDao produtoDuravelDao;

    @Inject
    private ProdutoNaoDuravelDao produtoNaoDuravelDao;

    @Inject
    private LivroDao livroDao;

    @Override
    public Produto executar(Properties properties) {
        String idString = properties.getProperty("id");
        Long id = idString != null && !idString.isEmpty() ? Long.parseLong(idString) : null;

        if (id != null) {
            return buscar(id);
        }

        return null;
    }

    private Produto buscar(Long id) {
        Produto produto;

        produto = produtoDuravelDao.buscar(id);

        if (produto == null) {
            produto = produtoNaoDuravelDao.buscar(id);
        }

        if (produto == null) {
            produto = livroDao.buscar(id);
        }

        return produto;
    }
}
