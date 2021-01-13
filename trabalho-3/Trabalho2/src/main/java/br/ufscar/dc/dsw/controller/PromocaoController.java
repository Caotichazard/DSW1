package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.domain.SiteReservas;
import br.ufscar.dc.dsw.service.spec.IPromocaoService;

import br.ufscar.dc.dsw.service.spec.IHotelService;

import br.ufscar.dc.dsw.service.spec.ISiteReservasService;

@RestController
public class PromocaoController {

	@Autowired
	private IPromocaoService service;

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private ISiteReservasService siteService;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}

	private void parse(Promocao promo, JSONObject json) {
					
			Object id = json.get("id");
			if (id != null) {
				if (id instanceof Integer) {
					promo.setId(((Integer) id).longValue());
				} else {
					promo.setId((Long) id);
				}
		}

			promo.setInicio((String) json.get("inicio"));
			promo.setFim((String) json.get("fim"));
			promo.setPreco((String) json.get("preco"));
			promo.setHotel((Hotel) json.get("hotel"));
			promo.setSite((SiteReservas) json.get("site"));
			
	}

	@GetMapping(path = "/promocoes")
	public ResponseEntity<List<Promocao>> lista() {
		List<Promocao> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping(path = "/promocoes/{id}")
	public ResponseEntity<Promocao> lista(@PathVariable("id") long id) {
		Promocao promo = service.buscarPorId(id);
		if (promo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(promo);
	}

	@GetMapping(path = "/promocoes/sites/{id}")
	public ResponseEntity<List<Promocao>> listaPorSite(@PathVariable("id") long id) {
		List<Promocao> promo = service.buscarPorSite(siteService.buscarPorId(id));
		if (promo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(promo);
	}
	
	@GetMapping(path = "/promocoes/sites/{id}")
	public ResponseEntity<List<Promocao>> listaPorHotel(@PathVariable("id") long id) {
		List<Promocao> promo = service.buscarPorHotel(hotelService.buscarPorId(id));
		if (promo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(promo);
	}
}