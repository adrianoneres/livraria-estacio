package me.adrianoneres.dao;

import me.adrianoneres.config.qualifier.LivrariaEstacioDatabase;
import me.adrianoneres.model.ProdutoNaoDuravel;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProdutoNaoDuravelDao extends DaoGenerico<ProdutoNaoDuravel> {

    @Inject
    public ProdutoNaoDuravelDao(@LivrariaEstacioDatabase EntityManager entityManager) {
        super(entityManager, ProdutoNaoDuravel.class);
    }

    @Override
    public List<ProdutoNaoDuravel> listar() {
        String queryString = "SELECT pnd FROM ProdutoNaoDuravel pnd WHERE pnd.tipo = 'NAO_DURAVEL'";
        TypedQuery<ProdutoNaoDuravel> query = getEntityManager().createQuery(queryString, ProdutoNaoDuravel.class);

        return query.getResultList();
    }

    public List<ProdutoNaoDuravel> listar(String nome) {
        String queryString = "SELECT pnd FROM ProdutoNaoDuravel pnd "
                + " WHERE pnd.tipo = 'NAO_DURAVEL' "
                + " AND LOWER(pnd.nome) LIKE LOWER(CONCAT('%', :nome, '%')) OR :nome IS NULL";

        TypedQuery<ProdutoNaoDuravel> query = getEntityManager().createQuery(queryString, ProdutoNaoDuravel.class);

        query.setParameter("nome", nome);

        return query.getResultList();
    }

    @Override
    public ProdutoNaoDuravel buscar(Long id) {
        String queryString = "SELECT pnd FROM ProdutoNaoDuravel pnd WHERE pnd.tipo = 'NAO_DURAVEL' AND pnd.id = :id";
        TypedQuery<ProdutoNaoDuravel> query = getEntityManager().createQuery(queryString, ProdutoNaoDuravel.class);

        query.setParameter("id", id);

        List<ProdutoNaoDuravel> result = query.getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        }

        return null;
    }
}
