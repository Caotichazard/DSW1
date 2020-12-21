package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Hotel;


public interface IHotelDAO extends CrudRepository<Hotel, Long> {
	List<Promocao> findByCidade(String cidade);

}