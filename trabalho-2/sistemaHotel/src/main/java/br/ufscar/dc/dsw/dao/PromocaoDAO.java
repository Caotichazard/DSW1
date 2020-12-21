package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.SiteReservas;
import br.ufscar.dc.dsw.domain.Promocao;

public interface IPromocaoDAO extends CrudRepository<Promocao, Long> {
	List<Promocao> findByHotel(Hotel hotel);
	List<Promocao> findBySiteReservas(SiteReservas siteReservas);
}