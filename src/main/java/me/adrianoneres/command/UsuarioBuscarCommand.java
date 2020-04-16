package me.adrianoneres.command;

import me.adrianoneres.dao.UsuarioDao;
import me.adrianoneres.model.Usuario;

import javax.inject.Inject;
import java.util.Properties;

public class UsuarioBuscarCommand implements Command {

    @Inject
    private UsuarioDao usuarioDao;

    @Override
    public Usuario executar(Properties properties) {
        String login = properties.getProperty("login");

        return usuarioDao.buscarPorLogin(login);
    }
}
