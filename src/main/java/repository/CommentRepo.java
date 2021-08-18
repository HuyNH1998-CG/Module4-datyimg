package repository;

import model.comments;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class CommentRepo implements ICommentRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<comments> findAll() {
        TypedQuery<comments> query = entityManager.createQuery("select c from comments as c", comments.class);
        return query.getResultList();
    }

    @Override
    public comments findById(int id) {
        TypedQuery<comments> query = entityManager.createQuery("select c from comments as c where c.id =:id", comments.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(comments comments) {
        if (comments.getId() != null) {
            entityManager.merge(comments);
        } else {
            entityManager.persist(comments);
        }
    }

    @Override
    public void remove(int id) {
        comments comments = findById(id);
        if (comments != null) {
            entityManager.remove(comments);
        }
    }

    @Override
    public void like(int id) {
        comments comments = findById(id);
        comments.setLikes(comments.getLikes() + 1);
        if (comments.getId() != null) {
            entityManager.merge(comments);
        } else {
            entityManager.persist(comments);
        }
    }
}
