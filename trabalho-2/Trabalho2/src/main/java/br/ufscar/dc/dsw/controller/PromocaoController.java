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
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.service.spec.IPromocaoService;

@Controller
@RequestMapping("/promocoes")
public class PromocaoController {
	
	@Autowired
	private IPromocaoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Promocao promocao) {
		return "promocao/cadastro";
	}

	@GetMapping("/")
	public String base(ModelMap model) {
		model.addAttribute("Promocoes",service.buscarTodos());
		return "promocao/lista";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("Promocoes",service.buscarTodos());
		return "promocao/lista";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(@Valid Promocao promocao, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "promocao/cadastro";
		}
		
		service.salvar(promocao);
		attr.addFlashAttribute("sucess", "Promocao inserida com sucesso.");
		return "redirect:/promocaos/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") String id, ModelMap model) {
		model.addAttribute("promocao", service.buscarPorId(Long.parseLong(id)));
		return "promocao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Promocao promocao, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "promocao/cadastro";
		}

		service.salvar(promocao);
		attr.addFlashAttribute("sucess", "Promocao editada com sucesso.");
		return "redirect:/promocaos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") String id, ModelMap model) {
		if (((service.buscarPorId(Long.parseLong(id))) == null)) {
			model.addAttribute("fail", "Promocao não excluíd0. Tal Promocao não existe.");
		} else {
			service.excluir(Long.parseLong(id));
			model.addAttribute("sucess", "Promocao excluído com sucesso.");
		}
		return listar(model);
	}
}