package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.service.spec.IHotelService;

@Controller
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private IHotelService service;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Hotel hotel) {
		return "hotel/cadastro";
	}

	@GetMapping("/")
	public String base(ModelMap model) {
		model.addAttribute("Hotels",service.buscarTodos());
		return "hotel/lista";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("Hotels",service.buscarTodos());
		return "hotel/lista";
	}
	@GetMapping("/listar/{cidade}")
	public String listarCidade(@PathVariable("cidade") String cidade,ModelMap model) {
		model.addAttribute("Hotels",service.buscarPorCidade(cidade));
		return "hotel/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Hotel Hotel, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "hotel/cadastro";
		}
		Hotel.setSenha(encoder.encode(Hotel.getSenha()));
		service.salvar(Hotel);
		attr.addFlashAttribute("sucess", "Hotel inserida com sucesso.");
		return "redirect:/hotels/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") String id, ModelMap model) {
		model.addAttribute("hotel", service.buscarPorId(Long.parseLong(id)));
		return "hotel/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Hotel Hotel, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "hotel/cadastro";
		}

		service.salvar(Hotel);
		attr.addFlashAttribute("sucess", "Hotel editada com sucesso.");
		return "redirect:/hotels/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") String id, ModelMap model) {
		if (((service.buscarPorId(Long.parseLong(id))) == null)) {
			model.addAttribute("fail", "Hotel não excluíd0. Tal Hotel não existe.");
		} else {
			service.excluir(Long.parseLong(id));
			model.addAttribute("sucess", "Hotel excluído com sucesso.");
		}
		return listar(model);
	}
}