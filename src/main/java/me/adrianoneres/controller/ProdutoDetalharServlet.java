package me.adrianoneres.controller;

import me.adrianoneres.command.ProdutoBuscarCommand;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/produto-detalhar")
public class ProdutoDetalharServlet extends HttpServlet {

    @Inject
    private ProdutoBuscarCommand produtoBuscarCommand;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Properties properties = new Properties();
        properties.put("id", request.getParameter("id"));

        request.setAttribute("produto", produtoBuscarCommand.executar(properties));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/produto/detalhar.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
