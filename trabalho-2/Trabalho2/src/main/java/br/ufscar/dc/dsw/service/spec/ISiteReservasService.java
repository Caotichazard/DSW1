package br.ufscar.dc.dsw.service.spec;
import java.util.List;
import br.ufscar.dc.dsw.domain.SiteReservas;
public interface ISiteReservasService {
	SiteReservas buscarPorId(Long id);
	List<SiteReservas> buscarTodos();
	void salvar(SiteReservas SiteReservas);
	void excluir(Long id);
	
}