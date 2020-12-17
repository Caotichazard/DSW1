package br.ufscar.dc.dsw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.ufscar.dc.dsw.domain.Promocao;

public class PromocaoDAO extends GenericDAO<Promocao>{

	@Override
	public Promocao find(String id) {
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Promocao sr = em.find(Promocao.class, id);
		tx.commit();
		em.close();
		return sr;
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Promocao> findAll() {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
		tx.begin();
        Query q = em.createQuery("SELECT p FROM Promocao p");
        List<Promocao> lista = q.getResultList();
        tx.commit();
        em.close();
        return lista;
    }

    @Override
    public void save(Promocao sr) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(sr);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Promocao sr) {
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
        Promocao sr = em.getReference(Promocao.class, id);
        tx.begin();
        em.remove(sr);
        tx.commit();
        em.close();
    }
}