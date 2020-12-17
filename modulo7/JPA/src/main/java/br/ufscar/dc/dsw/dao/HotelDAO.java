package br.ufscar.dc.dsw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.ufscar.dc.dsw.domain.Hotel;

public class HotelDAO extends GenericDAO<Hotel>{

	@Override
	public Hotel find(String id) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Hotel hotel = em.find(Hotel.class, id);
		tx.commit();
		em.close();
		return hotel;
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Hotel> findAll() {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
		tx.begin();
        Query q = em.createQuery("SELECT p FROM Hotel p");
        List<Hotel> lista = q.getResultList();
        tx.commit();
        em.close();
        return lista;
    }

    @Override
    public void save(Hotel hotel) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(hotel);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Hotel hotel) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(hotel);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Hotel hotel = em.getReference(Hotel.class, id);
        tx.begin();
        em.remove(hotel);
        tx.commit();
        em.close();
    }
}