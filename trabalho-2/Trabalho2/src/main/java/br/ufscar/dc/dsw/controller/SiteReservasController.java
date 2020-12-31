package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.ufscar.dc.dsw.domain.SiteReservas;
import br.ufscar.dc.dsw.service.spec.ISiteReservasService;

@Controller
@RequestMapping("/sites")
public class SiteReservasController {
	
	@Autowired
	private ISiteReservasService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(SiteReservas site) {
		return "site/cadastro";
	}

	@GetMapping("/")
	public String base(ModelMap model) {
		model.addAttribute("SiteReservass",service.buscarTodos());
		return "site/lista";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("Sites",service.buscarTodos());
		return "site/lista";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(@Valid SiteReservas SiteReservas, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "site/cadastro";
		}
		
		service.salvar(SiteReservas);
		attr.addFlashAttribute("sucess", "SiteReservas inserida com sucesso.");
		return "redirect:/sites/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") String id, ModelMap model) {
		model.addAttribute("site", service.buscarPorId(Long.parseLong(id)));
		return "site/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid SiteReservas SiteReservas, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "site/cadastro";
		}

		service.salvar(SiteReservas);
		attr.addFlashAttribute("sucess", "SiteReservas editada com sucesso.");
		return "redirect:/sites/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") String id, ModelMap model) {
		if (((service.buscarPorId(Long.parseLong(id))) == null)) {
			model.addAttribute("fail", "SiteReservas não excluíd0. Tal SiteReservas não existe.");
		} else {
			service.excluir(Long.parseLong(id));
			model.addAttribute("sucess", "SiteReservas excluído com sucesso.");
		}
		return listar(model);
	}
}