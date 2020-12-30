package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.domain.SiteReservas;

@SuppressWarnings("unchecked")
public interface IPromocaoDAO extends CrudRepository<Promocao, Long>{
	Promocao findById(long id);
	List<Promocao> findAll();
	Promocao save(Promocao promocao);
    void deleteById(Long id);
    List<Promocao> findByHotel(Hotel hotel);
    List<Promocao> findBySite(SiteReservas site);
}