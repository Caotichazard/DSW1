package br.ufscar.dc.dsw.controller;

import java.util.Collection;
import java.util.List;

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
import br.ufscar.dc.dsw.service.impl.PromocaoService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufscar.dc.dsw.service.spec.IHotelService;

import br.ufscar.dc.dsw.service.spec.ISiteReservasService;


@Controller
@RequestMapping("/promocoes")
public class PromocaoController {

	@Autowired
	private IPromocaoService service;

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private ISiteReservasService siteService;

	@GetMapping("/cadastrar")
	public String cadastrar(Promocao promocao, ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		System.out.println(userDetails.getAuthorities());
		
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_HOTEL"))){
			model.addAttribute("Hotels",hotelService.buscarPorLogin(userDetails.getUsername()));
			model.addAttribute("Sites", siteService.buscarTodos());
		}
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_SITE"))){
			model.addAttribute("Hotels", hotelService.buscarTodos());
			model.addAttribute("Sites",siteService.buscarPorLogin(userDetails.getUsername()));
		}

		

		return "promocao/cadastro";
	}

	@GetMapping("/")
	public String base(ModelMap model) {
		model.addAttribute("Promocoes", service.buscarTodos());
		return "promocao/lista";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		System.out.println(userDetails.getAuthorities());
		
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_HOTEL"))){
			System.out.println("AAAAAAAAAAA");
			model.addAttribute("Promocoes",service.buscarPorHotel(hotelService.buscarPorLogin(userDetails.getUsername())));
		}
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_SITE"))){
			model.addAttribute("Promocoes",service.buscarPorSite(siteService.buscarPorLogin(userDetails.getUsername())));
		}
		//model.addAttribute("Promocoes",service.buscarTodos());
		return "promocao/lista";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(@Valid Promocao promocao, BindingResult result, RedirectAttributes attr) {
		


		if (result.hasErrors()) {
			return "promocao/cadastro";
		}
		if (verificaDataPromocao(promocao)){
			return "promocao/cadastro";
		}
		
		service.salvar(promocao);
		attr.addFlashAttribute("sucess", "Promocao inserida com sucesso.");
		return "redirect:/promocoes/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") String id, ModelMap model) {
		Promocao promo = service.buscarPorId(Long.parseLong(id));
		model.addAttribute("promocao", promo);
		model.addAttribute("Hotels", promo.getHotel());
		model.addAttribute("Sites", promo.getSite());
		return "promocao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Promocao promocao, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "promocao/cadastro";
		}
		
		if (verificaDataPromocao(promocao)){
			return "promocao/cadastro";
		}
		service.salvar(promocao);
		attr.addFlashAttribute("sucess", "Promocao editada com sucesso.");
		return "redirect:/promocoes/listar";
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

	private boolean verificaDataPromocao(Promocao promocao){
		List<Promocao> promocoes = service.buscarPorHotel(promocao.getHotel());
		System.out.println("vamo funciona vamo pff vamo sim/n");
		for(int i = 0; i< promocoes.size(); i++){
			System.out.println("looperson");
			if(promocoes.get(i).getSite().equals(promocao.getSite()) && promocoes.get(i).getInicio().equals(promocao.getInicio()) && promocoes.get(i).getFim().equals(promocao.getFim())) {
				System.out.println("charlie brown hag loose");
				return true;
			}
		}
		return false;	

	}
}