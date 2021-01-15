package br.ufscar.dc.dsw.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ufscar.dc.dsw.domain.SiteReservas;
import br.ufscar.dc.dsw.service.spec.ISiteReservasService;

@Component
public class SiteReservasConversor implements Converter<String, SiteReservas>{

	@Autowired
	private ISiteReservasService service;
	
	@Override
	public SiteReservas convert(String text) {
		
		if (text.isEmpty()) {
		 return null;	
		}
		
		Long id = Long.valueOf(text);	
		return service.buscarPorId(id);
	}
}