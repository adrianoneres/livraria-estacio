package me.adrianoneres.command;

import me.adrianoneres.dao.AutorDao;
import me.adrianoneres.dao.LivroDao;
import me.adrianoneres.dao.ProdutoDuravelDao;
import me.adrianoneres.dao.ProdutoNaoDuravelDao;
import me.adrianoneres.model.*;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class ProdutoCadastrarCommand implements Command {

    @Inject
    private ProdutoDuravelDao produtoDuravelDao;

    @Inject
    private ProdutoNaoDuravelDao produtoNaoDuravelDao;

    @Inject
    private LivroDao livroDao;

    @Inject
    private AutorDao autorDao;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Produto executar(Properties properties) {
        TipoProduto tipoProduto = TipoProduto.valueOf(properties.getProperty("tipoProduto"));

        if (TipoProduto.DURAVEL.equals(tipoProduto)) {
            return cadastrarProdutoDuravel(properties);
        }

        if (TipoProduto.NAO_DURAVEL.equals(tipoProduto)) {
            return cadastrarProdutoNaoDuravel(properties);
        }

        return cadastrarLivro(properties);
    }

    private ProdutoDuravel cadastrarProdutoDuravel(Properties properties) {
        ProdutoDuravel produtoDuravel = new ProdutoDuravel();
        produtoDuravel.setTipo(TipoProduto.valueOf(properties.getProperty("tipoProduto")));
        produtoDuravel.setNome(properties.getProperty("nome"));
        produtoDuravel.setDescricao(properties.getProperty("descricao"));
        produtoDuravel.setPreco(Double.parseDouble(properties.getProperty("preco")));

        return produtoDuravelDao.incluir(produtoDuravel);
    }

    private ProdutoNaoDuravel cadastrarProdutoNaoDuravel(Properties properties) {
        ProdutoNaoDuravel produtoNaoDuravel = new ProdutoNaoDuravel();

        try {
            produtoNaoDuravel.setTipo(TipoProduto.valueOf(properties.getProperty("tipoProduto")));
            produtoNaoDuravel.setNome(properties.getProperty("nome"));
            produtoNaoDuravel.setDescricao(properties.getProperty("descricao"));
            produtoNaoDuravel.setPreco(Double.parseDouble(properties.getProperty("preco")));
            produtoNaoDuravel.setDataVencimento(simpleDateFormat.parse(properties.getProperty("dataVencimento")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return produtoNaoDuravelDao.incluir(produtoNaoDuravel);
    }

    private Livro cadastrarLivro(Properties properties) {
        Livro livro = new Livro();
        livro.setTipo(TipoProduto.valueOf(properties.getProperty("tipoProduto")));
        livro.setNome(properties.getProperty("nome"));
        livro.setDescricao(properties.getProperty("descricao"));
        livro.setPreco(Double.parseDouble(properties.getProperty("preco")));

        Long idAutor = Long.parseLong(properties.getProperty("autor"));

        livro.setAutor(autorDao.buscar(idAutor));

        return livroDao.incluir(livro);
    }
}
