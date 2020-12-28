package br.ufscar.dc.dsw;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import br.ufscar.dc.dsw.dao.*;
import br.ufscar.dc.dsw.domain.*;

@SpringBootApplication
public class SpringDaraJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringDaraJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDaraJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO) {
		return (args) -> {
			Hotel ibis = new Hotel("ibis@hotel.com","ibis123","812376478126","ibis","São Carlos");
			log.info("adicionando Hotel Ibis a base de dados");
			usuarioDAO.save(ibis);

			SiteReservas trivago = new SiteReservas("trivago@site.com","trivago123","trivago.com","trivago","9812642716");
			log.info("adicionando Site trivago a base de dados");
			usuarioDAO.save(trivago);

			List<Usuario> usuarios = usuarioDAO.findAll();
			log.info("Imprimindo pessoas - findAll()");
			for (Usuario u : usuarios) {
				log.info(u.toString());
			}

			return;
		};
	}
}
