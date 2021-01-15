package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.domain.SiteReservas;
public interface IPromocaoService {
	Promocao buscarPorId(Long id);
	List<Promocao> buscarTodos();
	void salvar(Promocao Promocao);
	void excluir(Long id);
	List<Promocao> buscarPorHotel(Hotel hotel);
	List<Promocao> buscarPorSite(SiteReservas site);
	
}