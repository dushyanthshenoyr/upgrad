package ImageHoster.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

import ImageHoster.model.Comment;


import javax.persistence.PersistenceUnit;

@Repository
public class CommentRepository {


    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;


    public Comment newComment(Comment comment){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return comment;

    }

    public List<Comment> getAllComments(Integer imageId) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Comment> query = em.createQuery("SELECT i from Comment i where i.image.id=:imageID", Comment.class);
            List<Comment> resultList = query.getResultList();
            return resultList;
        }
        catch (NoResultException nre){
            return null;
        }

    }



}
