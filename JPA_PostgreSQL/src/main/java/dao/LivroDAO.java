package dao;

import model.Livro;
import util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LivroDAO {
    private EntityManager entityManager;

    public LivroDAO() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    public Livro findById(Long id) {
        return entityManager.find(Livro.class, id);
    }

    public List<Livro> findAll() {
        TypedQuery<Livro> query = entityManager.createQuery("SELECT l FROM Livro l", Livro.class);
        return query.getResultList();
    }

    public void save(Livro livro) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(livro);
        transaction.commit();
    }

    public void update(Livro livro) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(livro);
        transaction.commit();
    }

    public void delete(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Livro livro = entityManager.find(Livro.class, id);
        if (livro != null) {
            entityManager.remove(livro);
        }
        transaction.commit();
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
