package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONObject;

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
import br.ufscar.dc.dsw.domain.SiteReservas;
import br.ufscar.dc.dsw.service.spec.ISiteReservasService;

@CrossOrigin
@RestController
public class SiteReservasController {
	
	@Autowired
	private ISiteReservasService service;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}

	private void parse(SiteReservas site, JSONObject json) {
		
		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				site.setId(((Integer) id).longValue());
			} else {
				site.setId((Long) id);
			}
	}


		site.setLogin((String) json.get("login"));
		site.setSenha((String) json.get("senha"));
		site.setPapel((String) json.get("papel"));

		site.setNome((String) json.get("nome"));
		site.setUrl((String) json.get("url"));
		site.setTelefone((String) json.get("telefone"));
		
	}

	@GetMapping(path = "/sites")
	public ResponseEntity<List<SiteReservas>> lista() {
		List<SiteReservas> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

	

	@GetMapping(path = "/sites/{id}")
	public ResponseEntity<SiteReservas> lista(@PathVariable("id") long id) {
		SiteReservas site = service.buscarPorId(id);
		if (site == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(site);
	}
 
	@PostMapping(path = "/sites")
	@ResponseBody
	public ResponseEntity<SiteReservas> cria(@RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				SiteReservas site = new SiteReservas();
				parse(site, json);
				service.salvar(site);
				return ResponseEntity.ok(site);
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}
 
	@PutMapping(path = "/sites/{id}")
	public ResponseEntity<SiteReservas> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
		try {
			if (isJSONValid(json.toString())) {
				SiteReservas site = service.buscarPorId(id);
				if (site == null) {
					return ResponseEntity.notFound().build();
				} else {
					parse(site, json);
					service.salvar(site);
					return ResponseEntity.ok(site);
				}
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}

	@DeleteMapping(path = "/sites/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {

		SiteReservas site = service.buscarPorId(id);
		if (site == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.excluir(id);
			return ResponseEntity.noContent().build();
		}
	}
}