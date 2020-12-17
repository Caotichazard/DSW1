package br.ufscar.dc.dsw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.ufscar.dc.dsw.domain.SiteReservas;

public class SiteReservasDAO extends GenericDAO<SiteReservas>{

	@Override
	public SiteReservas find(String id) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		SiteReservas sr = em.find(SiteReservas.class, id);
		tx.commit();
		em.close();
		return sr;
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public List<SiteReservas> findAll() {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
		tx.begin();
        Query q = em.createQuery("SELECT p FROM SiteReservas p");
        List<SiteReservas> lista = q.getResultList();
        tx.commit();
        em.close();
        return lista;
    }

    @Override
    public void save(SiteReservas sr) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(sr);
        tx.commit();
        em.close();
    }

    @Override
    public void update(SiteReservas sr) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(sr);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        SiteReservas sr = em.getReference(SiteReservas.class, id);
        tx.begin();
        em.remove(sr);
        tx.commit();
        em.close();
    }
}