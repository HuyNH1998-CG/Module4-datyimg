package Bid.Service;

import Bid.Model.Comment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class CommentIService implements CommentI {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> getComment() {
        String queryStr = "select c from Comment as c";
        TypedQuery<Comment>query = entityManager.createQuery(queryStr, Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment save(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(comment);
            transaction.commit();
            return comment;
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public Comment like(int id){
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Comment origin = findByID(id);
            origin.setLike(origin.getLike() + 1);
            session.save(origin);
            transaction.commit();
            return origin;
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public Comment findByID(int id) {
        String queryStr = "select c from Comment as c where c.id = :id";
        TypedQuery<Comment> query = entityManager.createQuery(queryStr, Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
