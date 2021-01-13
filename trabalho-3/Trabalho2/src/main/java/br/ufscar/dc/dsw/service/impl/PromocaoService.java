package br.ufscar.dc.dsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.IPromocaoDAO;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.domain.SiteReservas;
import br.ufscar.dc.dsw.service.spec.IPromocaoService;

@Service
@Transactional(readOnly = false)
public class PromocaoService implements IPromocaoService {

    @Autowired
    IPromocaoDAO dao;

    public void salvar(Promocao promocao) {
        dao.save(promocao);
    }

    public void excluir(Long id) {
        dao.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Promocao buscarPorId(Long id) {
        return dao.findById(id.longValue());
    }

    @Transactional(readOnly = true)
    public List<Promocao> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public List<Promocao> buscarPorHotel(Hotel hotel) {
        
        return dao.findByHotel(hotel);
    }

    @Override
    public List<Promocao> buscarPorSite(SiteReservas site) {
        
        return dao.findBySite(site);
    }


    
    
	
	
}