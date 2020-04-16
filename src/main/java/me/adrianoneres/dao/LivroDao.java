package me.adrianoneres.dao;

import me.adrianoneres.config.qualifier.LivrariaEstacioDatabase;
import me.adrianoneres.model.Livro;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class LivroDao extends DaoGenerico<Livro> {

    @Inject
    public LivroDao(@LivrariaEstacioDatabase EntityManager entityManager) {
        super(entityManager, Livro.class);
    }

    @Override
    public List<Livro> listar() {
        String queryString = "SELECT l FROM Livro l WHERE l.tipo = 'LIVRO'";
        TypedQuery<Livro> query = getEntityManager().createQuery(queryString, Livro.class);

        return query.getResultList();
    }

    public List<Livro> listar(String nome) {
        String queryString = "SELECT l FROM Livro l "
                + " WHERE l.tipo = 'LIVRO' "
                + " AND LOWER(l.nome) LIKE LOWER(CONCAT('%', :nome, '%')) OR :nome IS NULL";

        TypedQuery<Livro> query = getEntityManager().createQuery(queryString, Livro.class);

        query.setParameter("nome", nome);

        return query.getResultList();
    }

    @Override
    public Livro buscar(Long id) {
        String queryString = "SELECT l FROM Livro l WHERE l.tipo = 'LIVRO' AND l.id = :id";
        TypedQuery<Livro> query = getEntityManager().createQuery(queryString, Livro.class);

        query.setParameter("id", id);

        List<Livro> result = query.getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        }

        return null;
    }
}
