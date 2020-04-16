package me.adrianoneres.controller;

import me.adrianoneres.command.UsuarioBuscarCommand;
import me.adrianoneres.model.Usuario;
import me.adrianoneres.util.Criptografia;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private UsuarioBuscarCommand usuarioBuscarCommand;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");

            Properties properties = new Properties();
            properties.setProperty("login", login);

            Usuario usuario = usuarioBuscarCommand.executar(properties);

            if (usuario == null) {
                retornarUsuarioOuSenhaInvalidos(request, response).forward(request, response);
            }

            String senhaCriptografada = Criptografia.criptografar(senha);

            if (!senhaCriptografada.equals(usuario.getSenha())) {
                retornarUsuarioOuSenhaInvalidos(request, response).forward(request, response);
            }

            HttpSession session = request.getSession();
            session.setAttribute("nomeUsuarioLogado", usuario.getNome());

            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/home.jsp");
            dispatcher.forward(request, response);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            retornarUsuarioOuSenhaInvalidos(request, response).forward(request, response);
        }
    }

    private RequestDispatcher retornarUsuarioOuSenhaInvalidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mensagemErro", "Usuario ou senha invalidos.");
        return request.getRequestDispatcher("/");
    }

}
