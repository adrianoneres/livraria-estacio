package me.adrianoneres.dao;

import me.adrianoneres.config.qualifier.LivrariaEstacioDatabase;
import me.adrianoneres.model.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UsuarioDao extends DaoGenerico<Usuario> {

    @Inject
    public UsuarioDao(@LivrariaEstacioDatabase EntityManager entityManager) {
        super(entityManager, Usuario.class);
    }

    public Usuario buscarPorLogin(String login) {
        Query query = getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.login = :login");

        query.setParameter("login", login);

        List<Usuario> usuarios = query.getResultList();

        if (usuarios == null || usuarios.isEmpty()) {
            return null;
        }

        return usuarios.get(0);
    }
}
