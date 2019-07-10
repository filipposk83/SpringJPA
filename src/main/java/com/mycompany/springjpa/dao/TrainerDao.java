package com.mycompany.springjpa.dao;

import com.mycompany.springjpa.entities.Trainer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class TrainerDao {

    public List<Trainer> getTrainers() {
        List<Trainer> trainers = null;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("com.mycompany_SpringJPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createNamedQuery("Trainer.findAll");
            trainers = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return trainers;
    }

    public Trainer getTrainerById(Long id) {
        Trainer t = null;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("com.mycompany_SpringJPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createNamedQuery("Trainer.findByTrainerId").setParameter("trainerId", id);
            t = (Trainer) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return t;
    }

    public boolean insertTrainer(Trainer t) {
        boolean inserted = false;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("com.mycompany_SpringJPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(t);
            em.getTransaction().commit();
            inserted = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return inserted;
    }
    
    public boolean deleteTrainer(Long id) {
        boolean deleted = false;
        Trainer t = null;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("com.mycompany_SpringJPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createNamedQuery("Trainer.findByTrainerId").setParameter("trainerId", id);
            t = (Trainer) query.getSingleResult();
            em.remove(t);
            em.getTransaction().commit();
            deleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return deleted;
    }
    //???????????????????????????????????????????????????????????????????????????
    public boolean updateTrainer(Trainer t) {
        boolean updated = false;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("com.mycompany_SpringJPA_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(t);
            em.getTransaction().commit();
            updated = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return updated;
    }
    
    

}
