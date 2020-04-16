package me.adrianoneres.controller;

import me.adrianoneres.command.AutorListarCommand;
import me.adrianoneres.command.ProdutoCadastrarCommand;
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

@WebServlet("/produto-cadastrar")
public class ProdutoCadastrarServlet extends HttpServlet {

    @Inject
    private AutorListarCommand autorListarCommand;

    @Inject
    private ProdutoCadastrarCommand produtoCadastrarCommand;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tiposProduto", TipoProduto.values());
        request.setAttribute("autores", autorListarCommand.executar(null));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/produto/cadastrar.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Properties properties = new Properties();
        properties.put("nome", request.getParameter("nome"));
        properties.put("tipoProduto", request.getParameter("tipoProduto"));
        properties.put("dataVencimento", request.getParameter("dataVencimento"));
        properties.put("autor", request.getParameter("autor"));
        properties.put("descricao", request.getParameter("descricao").trim());
        properties.put("preco", request.getParameter("preco"));

        Produto produto = produtoCadastrarCommand.executar(properties);

        response.sendRedirect(request.getContextPath() + "/produto-detalhar?id=" + produto.getId());
    }
}