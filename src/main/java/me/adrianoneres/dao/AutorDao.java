package me.adrianoneres.dao;

import me.adrianoneres.config.qualifier.LivrariaEstacioDatabase;
import me.adrianoneres.model.Autor;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class AutorDao extends DaoGenerico<Autor> {

    @Inject
    public AutorDao(@LivrariaEstacioDatabase EntityManager entityManager) {
        super(entityManager, Autor.class);
    }
}
