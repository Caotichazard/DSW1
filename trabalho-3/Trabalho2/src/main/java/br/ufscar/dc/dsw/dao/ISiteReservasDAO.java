package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.SiteReservas;

@SuppressWarnings("unchecked")
public interface ISiteReservasDAO extends CrudRepository<SiteReservas, Long>{
	
    SiteReservas findById(long id);
	List<SiteReservas> findAll();
	SiteReservas save(SiteReservas usuario);
	void deleteById(Long id);
	SiteReservas findByLogin(String login);
	
}