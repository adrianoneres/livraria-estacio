package me.adrianoneres.config.producer;

import me.adrianoneres.config.qualifier.LivrariaEstacioDatabase;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerProducer {

    @Produces
    @LivrariaEstacioDatabase
    public EntityManager createEntityManager() {
        return Persistence
                .createEntityManagerFactory("livraria-estacio")
                .createEntityManager();
    }

    public void close(@Disposes @LivrariaEstacioDatabase EntityManager entityManager) {
        entityManager.close();
    }
}
