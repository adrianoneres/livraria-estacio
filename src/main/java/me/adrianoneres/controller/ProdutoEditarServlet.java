package me.adrianoneres.controller;

import me.adrianoneres.command.AutorListarCommand;
import me.adrianoneres.command.ProdutoBuscarCommand;
import me.adrianoneres.command.ProdutoEditarCommand;
import me.adrianoneres.model.Produto;
import me.adrianoneres.model.TipoProduto;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/produto-editar")
public class ProdutoEditarServlet extends HttpServlet {

    @Inject
    private ProdutoBuscarCommand produtoBuscarCommand;

    @Inject
    private AutorListarCommand autorListarCommand;

    @Inject
    private ProdutoEditarCommand produtoEditarCommand;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tiposProduto", TipoProduto.values());
        request.setAttribute("autores", autorListarCommand.executar(null));

        Properties properties = new Properties();
        properties.setProperty("id", request.getParameter("id"));

        request.setAttribute("produto", produtoBuscarCommand.executar(properties));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/produto/editar.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Properties properties = new Properties();
        properties.put("id", request.getParameter("id"));
        properties.put("nome", request.getParameter("nome"));
        properties.put("tipoProduto", request.getParameter("tipoProduto"));
        properties.put("dataVencimento", request.getParameter("dataVencimento"));
        properties.put("autor", request.getParameter("autor"));
        properties.put("descricao", request.getParameter("descricao").trim());
        properties.put("preco", request.getParameter("preco"));

        Produto produto = produtoEditarCommand.executar(properties);

        response.sendRedirect(request.getContextPath() + "/produto-detalhar?id=" + produto.getId());
    }
}