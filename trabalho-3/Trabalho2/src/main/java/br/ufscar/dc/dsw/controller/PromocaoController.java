package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.service.spec.IPromocaoService;



import br.ufscar.dc.dsw.service.spec.IHotelService;

import br.ufscar.dc.dsw.service.spec.ISiteReservasService;

@CrossOrigin
@RestController
public class PromocaoController {

	@Autowired
	private IPromocaoService service;

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private ISiteReservasService siteService;

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
		Promocao promocao = service.buscarPorId(id);
		if (promocao == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(promocao);
	 }

	@GetMapping(path = "/promocoes/sites/{id}")
	public ResponseEntity<List<Promocao>> listaPorSite(@PathVariable("id") long id) {
		List<Promocao> lista = service.buscarPorSite(siteService.buscarPorId(id));
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping(path = "/promocoes/hoteis/{id}")
	public ResponseEntity<List<Promocao>> listaPorHotel(@PathVariable("id") long id) {
		List<Promocao> lista = service.buscarPorHotel(hotelService.buscarPorId(id));
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
}