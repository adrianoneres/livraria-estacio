package me.adrianoneres.dao;

import me.adrianoneres.config.qualifier.LivrariaEstacioDatabase;
import me.adrianoneres.model.ProdutoDuravel;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProdutoDuravelDao extends DaoGenerico<ProdutoDuravel> {

    @Inject
    public ProdutoDuravelDao(@LivrariaEstacioDatabase EntityManager entityManager) {
        super(entityManager, ProdutoDuravel.class);
    }

    @Override
    public List<ProdutoDuravel> listar() {
        String queryString = "SELECT pd FROM ProdutoDuravel pd WHERE pd.tipo = 'DURAVEL'";
        TypedQuery<ProdutoDuravel> query = getEntityManager().createQuery(queryString, ProdutoDuravel.class);

        return query.getResultList();
    }

    public List<ProdutoDuravel> listar(String nome) {
        String queryString = "SELECT pd FROM ProdutoDuravel pd "
            + " WHERE pd.tipo = 'DURAVEL' "
            + " AND LOWER(pd.nome) LIKE LOWER(CONCAT('%', :nome, '%')) OR :nome IS NULL";

        TypedQuery<ProdutoDuravel> query = getEntityManager().createQuery(queryString, ProdutoDuravel.class);

        query.setParameter("nome", nome);

        return query.getResultList();
    }

    @Override
    public ProdutoDuravel buscar(Long id) {
        String queryString = "SELECT pd FROM ProdutoDuravel pd WHERE pd.tipo = 'DURAVEL' AND pd.id = :id";
        TypedQuery<ProdutoDuravel> query = getEntityManager().createQuery(queryString, ProdutoDuravel.class);

        query.setParameter("id", id);

        List<ProdutoDuravel> result = query.getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        }

        return null;
    }
}
