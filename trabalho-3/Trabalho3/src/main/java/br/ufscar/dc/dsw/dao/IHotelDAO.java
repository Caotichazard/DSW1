package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Hotel;

@SuppressWarnings("unchecked")
public interface IHotelDAO extends CrudRepository<Hotel, Long>{
	
    List<Hotel> findByCidade(String cidade);
    List<Hotel> findAll();
    Hotel findById(long id);
    Hotel findByLogin(String login);
	
}