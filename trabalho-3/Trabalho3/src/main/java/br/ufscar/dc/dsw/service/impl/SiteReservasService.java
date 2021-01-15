package br.ufscar.dc.dsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.ISiteReservasDAO;
import br.ufscar.dc.dsw.domain.SiteReservas;
import br.ufscar.dc.dsw.service.spec.ISiteReservasService;

@Service
@Transactional(readOnly = false)
public class SiteReservasService implements ISiteReservasService {

	@Autowired
	ISiteReservasDAO dao;
	
	public void salvar(SiteReservas SiteReservas) {
		dao.save(SiteReservas);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public SiteReservas buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<SiteReservas> buscarTodos() {
		return dao.findAll();
    }


    @Transactional(readOnly = true)
	public SiteReservas buscarPorLogin(String login) {
		return dao.findByLogin(login);
	}
    
	
	
}