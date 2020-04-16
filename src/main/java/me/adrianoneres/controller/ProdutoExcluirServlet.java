package me.adrianoneres.controller;

import me.adrianoneres.command.ProdutoExcluirCommand;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/produto-excluir")
public class ProdutoExcluirServlet extends HttpServlet {

    @Inject
    private ProdutoExcluirCommand produtoExcluirCommand;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Properties properties = new Properties();
        properties.put("id", request.getParameter("id"));
        properties.put("tipoProduto", request.getParameter("tipoProduto"));

        produtoExcluirCommand.executar(properties);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/produto-listar");
        dispatcher.forward(request, response);
    }
}
