package me.adrianoneres.command;

import me.adrianoneres.dao.*;
import me.adrianoneres.model.*;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class ProdutoEditarCommand implements Command {

    @Inject
    private ProdutoBuscarCommand produtoBuscarCommand;

    @Inject
    private ProdutoDuravelDao produtoDuravelDao;

    @Inject
    private ProdutoNaoDuravelDao produtoNaoDuravelDao;

    @Inject
    private LivroDao livroDao;

    @Inject
    private AutorDao autorDao;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Produto executar(Properties properties) {
        Produto produto = produtoBuscarCommand.executar(properties);
        TipoProduto tipoProduto = TipoProduto.valueOf(properties.getProperty("tipoProduto"));

        if (TipoProduto.DURAVEL.equals(tipoProduto)) {
            return editarProdutoDuravel(produto, properties);
        }

        if (TipoProduto.NAO_DURAVEL.equals(tipoProduto)) {
            return editarProdutoNaoDuravel(produto, properties);
        }

        return editarLivro(produto, properties);
    }

    private ProdutoDuravel editarProdutoDuravel(Produto produto, Properties properties) {
        ProdutoDuravel produtoDuravel = modelMapper.map(produto, ProdutoDuravel.class);
        produtoDuravel.setTipo(TipoProduto.valueOf(properties.getProperty("tipoProduto")));
        produtoDuravel.setNome(properties.getProperty("nome"));
        produtoDuravel.setDescricao(properties.getProperty("descricao"));
        produtoDuravel.setPreco(Double.parseDouble(properties.getProperty("preco")));

        return produtoDuravelDao.editar(produtoDuravel);
    }

    private ProdutoNaoDuravel editarProdutoNaoDuravel(Produto produto, Properties properties) {
        ProdutoNaoDuravel produtoNaoDuravel = modelMapper.map(produto, ProdutoNaoDuravel.class);

        try {
            produtoNaoDuravel.setTipo(TipoProduto.valueOf(properties.getProperty("tipoProduto")));
            produtoNaoDuravel.setNome(properties.getProperty("nome"));
            produtoNaoDuravel.setDescricao(properties.getProperty("descricao"));
            produtoNaoDuravel.setPreco(Double.parseDouble(properties.getProperty("preco")));
            produtoNaoDuravel.setDataVencimento(simpleDateFormat.parse(properties.getProperty("dataVencimento")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return produtoNaoDuravelDao.editar(produtoNaoDuravel);
    }

    private Livro editarLivro(Produto produto, Properties properties) {
        Livro livro = modelMapper.map(produto, Livro.class);
        livro.setTipo(TipoProduto.valueOf(properties.getProperty("tipoProduto")));
        livro.setNome(properties.getProperty("nome"));
        livro.setDescricao(properties.getProperty("descricao"));
        livro.setPreco(Double.parseDouble(properties.getProperty("preco")));

        Long idAutor = Long.parseLong(properties.getProperty("autor"));

        livro.setAutor(autorDao.buscar(idAutor));

        return livroDao.editar(livro);
    }
}
