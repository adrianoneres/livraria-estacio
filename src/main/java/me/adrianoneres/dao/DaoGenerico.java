package me.adrianoneres.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class DaoGenerico<T> {

    private Class<T> clazz;
    private EntityManager entityManager;

    public DaoGenerico(EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    public List<T> listar() {
        TypedQuery<T> query = entityManager.createQuery(String.format("SELECT x FROM %s x", clazz.getName()), clazz);
        return query.getResultList();
    }

    public T incluir(T registro) {
        entityManager.getTransaction().begin();
        entityManager.persist(registro);
        entityManager.flush();
        entityManager.getTransaction().commit();

        return registro;
    }

    public T buscar(Long id) {
        return (T) entityManager.find(clazz, id);
    }

    public T editar(T registro) {
        entityManager.getTransaction().begin();
        entityManager.merge(registro);
        entityManager.flush();
        entityManager.getTransaction().commit();

        return registro;
    }

    public void excluir(Long id) {
        entityManager.getTransaction().begin();
        T registro = entityManager.find(clazz, id);
        entityManager.remove(registro);
        entityManager.getTransaction().commit();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
