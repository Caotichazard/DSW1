package br.ufscar.dc.dsw;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import br.ufscar.dc.dsw.dao.*;
import br.ufscar.dc.dsw.domain.*;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Trabalho2Application {

	private static final Logger log = LoggerFactory.getLogger(Trabalho2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Trabalho2Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, IPromocaoDAO promocaoDAO, IHotelDAO hotelDAO, BCryptPasswordEncoder encoder) {
		return (args) -> {

			Usuario admin = new Usuario("admin",encoder.encode("admin"),"ROLE_ADMIN");
			usuarioDAO.save(admin);

			Hotel ibis = new Hotel("ibis@hotel.com",encoder.encode("ibis123"),"812376478126","ibis","São Carlos");
			log.info("adicionando Hotel Ibis a base de dados");
			usuarioDAO.save(ibis);

			Hotel catussaba = new Hotel("catussaba@hotel.com",encoder.encode("catussaba123"),"43846897192","Catussaba","Salvador");
			log.info("adicionando Hotel Catussaba a base de dados");
			usuarioDAO.save(catussaba);

			Hotel catussaba2 = new Hotel("catussaba2@hotel.com",encoder.encode("catussaba456"),"4182367812387","Catussaba","Descalvado");
			log.info("adicionando Hotel Catussaba a base de dados");
			usuarioDAO.save(catussaba2);

			Hotel descalvado = new Hotel("descalvado@hotel.com",encoder.encode("descalvado123"),"98235729473","descalvado","Descalvado");
			log.info("adicionando Hotel Descalvado a base de dados");
			usuarioDAO.save(descalvado);

			SiteReservas trivago = new SiteReservas("trivago@site.com",encoder.encode("trivago123"),"trivago.com","trivago","9812642716");
			log.info("adicionando Site trivago a base de dados");
			usuarioDAO.save(trivago);

			SiteReservas giramundo = new SiteReservas("giramundo@site.com",encoder.encode("giramundo123"),"giramundo.com","giramundo","3894724792");
			log.info("adicionando Site giramundo a base de dados");
			usuarioDAO.save(giramundo);

			SiteReservas booking = new SiteReservas("booking@site.com",encoder.encode("booking123"),"booking.com","booking","624859902348");
			log.info("adicionando Site booking a base de dados");
			usuarioDAO.save(booking);

			List<Usuario> usuarios = usuarioDAO.findAll();
			log.info("Imprimindo usuarios - findAll()");
			for (Usuario u : usuarios) {
				log.info(u.toString());
			}

			
			List<Hotel> hoteisCidade = hotelDAO.findAll();
			log.info("Imprimindo hoteis de descalvado - findAllbyCidadeHotels()");
			for (Usuario u : hoteisCidade) {
				log.info(u.toString());
			}
			

			Promocao promo1 = new Promocao(ibis,trivago,"200","1-1-2020","5-1-2020");
			log.info("adicionando Promoção 1 a base de dados");
			promocaoDAO.save(promo1);

			Promocao promo2 = new Promocao(descalvado,trivago,"200","1-1-2020","5-1-2020");
			log.info("adicionando Promoção 2 a base de dados");
			promocaoDAO.save(promo2);

			Promocao promo3 = new Promocao(descalvado,booking,"200","1-1-2020","5-1-2020");
			log.info("adicionando Promoção 3 a base de dados");
			promocaoDAO.save(promo3);


			List<Promocao> promocoes = promocaoDAO.findAll();
			log.info("Imprimindo promocoes - findAll()");
			for (Promocao p : promocoes) {
				log.info(p.toString());
			}

			List<Promocao> promocoesHotel = promocaoDAO.findByHotel(descalvado);
			log.info("Imprimindo promocoes de um hotel - findByHotel()");
			for (Promocao p : promocoesHotel) {
				log.info(p.toString());
			}

			List<Promocao> promocoesSite = promocaoDAO.findBySite(trivago);
			log.info("Imprimindo promocoes de um site - findBySite()");
			for (Promocao p : promocoesSite) {
				log.info(p.toString());
			}


			
	 
	 
			return;
			
		};
	}
}
