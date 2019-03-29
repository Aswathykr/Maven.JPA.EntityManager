package services;

import entities.CD;
import entities.Musician;
import javax.persistence.*;
import java.util.Set;

public class CDService {
    EntityManager em = null;
    EntityTransaction tx = null;

    public CDService(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }

    public CD createCD(String title, String desc, int year, Set<Musician> artists, int price){

        CD cd = new CD();
        cd.setTitle(title);
        cd.setDescription(desc);
        cd.setYear(year);
        cd.setMusicians(artists);
        cd.setPrice(price);
        tx.begin();
        em.persist(cd);
        tx.commit();

        System.out.println("from Service ******** + " + cd.getId());
        return cd;
    }

    public CD createCD(CD cd){
        tx.begin();
        em.persist(cd);
        tx.commit();
        System.out.println("from Service ******** + " + cd.getId());

        return cd;
    }

    public CD findMusician(int id) {
        return em.find(CD.class, id);
    }

    public void removeCD(int id){
        CD cd = em.find(CD.class, id);
        if(cd != null){
            tx.begin();
            em.remove(cd);
            tx.commit();
        }
    }

    public void removeCD(CD cd){
        CD cdToBeDeleted = em.merge(cd);
        tx.begin();
        em.remove(cdToBeDeleted);
        tx.commit();
    }

//    public CD raiseUnitCost(Long id, Float raise) {
//        CD cd = em.find(CD.class, id);
//        if(cd != null){
//            tx.begin();
//            cd.setUnitCost(cd.getUnitCost() + raise);
//            tx.commit();
//        }
//        return cd;
//    }
//
//    public CD raiseUnitCost(CD cd, Float raise) {
//        CD cdToBeUpdated = em.merge(cd);
//
//        tx.begin();
//        cdToBeUpdated.setUnitCost(cdToBeUpdated.getUnitCost() + raise);
//        tx.commit();
//        return cd;
//    }

}
