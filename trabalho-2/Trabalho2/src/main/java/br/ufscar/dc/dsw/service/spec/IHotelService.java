package br.ufscar.dc.dsw.service.spec;
import java.util.List;
import br.ufscar.dc.dsw.domain.Hotel;
public interface IHotelService {
	Hotel buscarPorId(Long id);
	List<Hotel> buscarTodos();
	List<Hotel> buscarPorCidade(String cidade);
	void salvar(Hotel Hotel);
	void excluir(Long id);
	Hotel buscarPorLogin(String login);
	
}