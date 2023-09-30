package dao;

import model.Editora;
import util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EditoraDAO {
    private EntityManager entityManager;

    public EditoraDAO() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    public Editora findById(Long id) {
        return entityManager.find(Editora.class, id);
    }

    public List<Editora> findAll() {
        TypedQuery<Editora> query = entityManager.createQuery("SELECT e FROM Editora e", Editora.class);
        return query.getResultList();
    }

    public void save(Editora editora) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(editora);
        transaction.commit();
    }

    public void update(Editora editora) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(editora);
        transaction.commit();
    }

    public void delete(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Editora editora = entityManager.find(Editora.class, id);
        if (editora != null) {
            entityManager.remove(editora);
        }
        transaction.commit();
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
