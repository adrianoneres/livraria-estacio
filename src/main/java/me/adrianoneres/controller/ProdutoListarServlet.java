package me.adrianoneres.controller;

import me.adrianoneres.command.ProdutoFiltrarCommand;
import me.adrianoneres.command.ProdutoListarCommand;
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

@WebServlet("/produto-listar")
public class ProdutoListarServlet extends HttpServlet {

    @Inject
    private ProdutoListarCommand produtoListarCommand;

    @Inject
    private ProdutoFiltrarCommand produtoFiltrarCommand;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tiposProduto", TipoProduto.values());
        request.setAttribute("produtos", produtoListarCommand.executar(null));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/produto/listar.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Properties properties = new Properties();
        properties.put("tipoProduto", request.getParameter("tipoProduto"));
        properties.put("nome", request.getParameter("nome"));

        request.setAttribute("tiposProduto", TipoProduto.values());
        request.setAttribute("tipoProdutoFiltro", properties.getProperty("tipoProduto"));
        request.setAttribute("nomeFiltro", properties.getProperty("nome"));
        request.setAttribute("produtos", produtoFiltrarCommand.executar(properties));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/produto/listar.jsp");
        dispatcher.forward(request, response);
    }
}
