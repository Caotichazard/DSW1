package br.ufscar.dc.dsw;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.domain.Hotel;

import br.ufscar.dc.dsw.dao.SiteReservasDAO;
import br.ufscar.dc.dsw.domain.SiteReservas;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.domain.Promocao;

public class App {

	public static void main(String[] args) {

		HotelDAO hotelDAO = new HotelDAO();

        Hotel ibis = new Hotel("4932749823","Ibis", "São Carlos","ibis@hotel.com","ibis123");
        Hotel sj = new Hotel("9573489573","SanJermane", "São Carlos","sanjermane@hotel.com","sanjermane123");
        Hotel plaza = new Hotel("3424324434","Plaza", "Salvador","plaza@hotel.com","plaza123");
        Hotel daily = new Hotel("3634545351","Daily", "New York","dailyNW@hotel.com","dailyNW123");

		System.out.println("Salvando Hoteis");

        hotelDAO.save(ibis);
        hotelDAO.save(sj);
        hotelDAO.save(plaza);
		hotelDAO.save(daily);
		
		List<Hotel> hoteis = hotelDAO.findAll();

		System.out.println("Imprimindo hoteis - findAll()");

		for (Hotel h : hoteis) {
			System.out.println(h);
		}
		
		//HotelDAO.close();

		SiteReservasDAO siteReservasDAO = new SiteReservasDAO();

        SiteReservas trivago = new SiteReservas("trivago@site.com","trivago123", "trivago.com","trivago","123213123213");
        SiteReservas reserveiro = new SiteReservas("reserveiro@site.com","reserveiro123", "reserveiro.com","reserveiro","3454353453");
        SiteReservas bla = new SiteReservas("bla@site.com","bla123", "bla.com","bla","64356435234");
        SiteReservas blo = new SiteReservas("blo@site.com","blo123", "blo.com","blo","2432414231");

		System.out.println("Salvando Sites de reservas");

        siteReservasDAO.save(trivago);
        siteReservasDAO.save(reserveiro);
        siteReservasDAO.save(bla);
		siteReservasDAO.save(blo);
		
		List<SiteReservas> sites = siteReservasDAO.findAll();

		System.out.println("Imprimindo Sites de reservas - findAll()");

		for (SiteReservas s : sites) {
			System.out.println(s);
		}

		UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario admin = new Usuario("admin","admin", "ADMIN","admin");
        Usuario reserveiroUser = new Usuario("reserveiro@site.com","reserveiro", "SITE","reserveiro123");
        Usuario ibisUser = new Usuario("ibis@hotel.com","Ibis", "HOTEL","ibis123");
        Usuario user = new Usuario("usuario","usuario", "USER","user123");

		System.out.println("Salvando Usuarios");

        usuarioDAO.save(admin);
        usuarioDAO.save(reserveiroUser);
        usuarioDAO.save(ibisUser);
		usuarioDAO.save(user);
		
		List<Usuario> usuarios = usuarioDAO.findAll();

		System.out.println("Imprimindo Usuarios - findAll()");

		for (Usuario u : usuarios) {
			System.out.println(u);
		}
		
		//usuarioDAO.close();

		PromocaoDAO promocaoDAO = new PromocaoDAO();

        Promocao p1 = new Promocao("trivago@site.com","Ibis", "322","01/01/2021","10/01/2021");
        Promocao p2 = new Promocao("trivago@site.com","Plaza", "544","01/01/2021","10/01/2021");
        Promocao p3 = new Promocao("reserveiro@site.com","Ibis", "322","11/01/2021","20/01/2021");
        Promocao p4 = new Promocao("reserveiro@site.com","Plaza", "322","21/01/2021","01/02/2021");

		System.out.println("Salvando Promocoes");

        promocaoDAO.save(p1);
        promocaoDAO.save(p2);
        promocaoDAO.save(p3);
		promocaoDAO.save(p4);
		
		List<Promocao> promocoes = promocaoDAO.findAll();

		System.out.println("Imprimindo Promocoes - findAll()");

		for (Promocao p : promocoes) {
			System.out.println(p);
		}
		
		promocaoDAO.close();
	}
}