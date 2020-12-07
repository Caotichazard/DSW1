
package br.ufscar.dc.dsw.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.domain.Promocao;

import br.ufscar.dc.dsw.dao.SiteReservasDAO;
import br.ufscar.dc.dsw.domain.SiteReservas;

import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.domain.Hotel;

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.UsuarioDAO;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


//Alterar os argumentos para ficar correto em relação ao hotel
@WebServlet(urlPatterns = {"/hotels/promocoes/*","/sites/promocoes/*"})
public class PromocaoController extends HttpServlet {

    private static final long serialVersionUID = 1L; 
    private PromocaoDAO dao;
    private SiteReservasDAO sitesDao;
    private HotelDAO hotelDao;
    

    @Override
    public void init() {
        dao = new PromocaoDAO();
        sitesDao = new SiteReservasDAO();
        hotelDao = new HotelDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {           
        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                
                case "/remocao":
                    remove(request, response);
                    break;
                
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                
                    
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario user = (Usuario) request.getSession().getAttribute("usuarioLogado");
        
        System.out.print(request.getServletPath());
        if(request.getServletPath().contains("hotels")){
            Hotel tempHotel = hotelDao.getByEmail(user.getLogin());
            String hotelCNPJ = tempHotel.getCNPJ();
            List<Promocao> listaPromocaos = dao.getAllbyHotel(hotelCNPJ);
            request.setAttribute("listaPromocaos", listaPromocaos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/promocao/listaPromocoes.jsp");
            dispatcher.forward(request, response);
        }
        if(request.getServletPath().contains("sites")){
            SiteReservas tempSite = sitesDao.getbyEmail(user.getLogin());
            String siteURL = tempSite.getUrl();
            List<Promocao> listaPromocaos = dao.getAllbySite(siteURL);
            request.setAttribute("listaPromocaos", listaPromocaos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/site/promocao/listaPromocoes.jsp");
            dispatcher.forward(request, response);
        }
        //System.out.print(hotelCNPJ);
        
        
        //dispatcher.forward(request, response);
    }
   
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> listaSites = sitesDao.getAllUrls();
        //System.out.print(listaSites);
        request.setAttribute("listaSiteReserva",listaSites);
        //Hotel hotel = hotelDao.getByEmail(request.getSession().getAttribute("usuarioLogado.login"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/promocao/cadastroPromocao.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");
        Promocao promocao = dao.getbyID(Long.parseLong(ID));
        request.setAttribute("promocao", promocao);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/promocao/edicaoPromocao.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        

        String url = request.getParameter("siteReserva");

        String hotel = request.getParameter("hotel");

        Hotel tempHotel = hotelDao.getByEmail(hotel);

        String hotelCNPJ = tempHotel.getCNPJ();

        System.out.print(hotelCNPJ);

        String preco = request.getParameter("preco");

        String inicio = request.getParameter("inicio");

        String fim = request.getParameter("fim");

        List<Promocao> listaPromocaos = dao.getAllbyHotel(hotelCNPJ);

        String URL_;

        LocalDate INI_;

        LocalDate FIM_;

        int flag = 0;

        for( Promocao promo : listaPromocaos){

            URL_ = promo.getUrlSite();

            INI_ = promo.getInicio();

            FIM_ = promo.getFim();

            if(URL_.equals(url) && INI_.equals(LocalDate.parse(inicio,DateTimeFormatter.ISO_LOCAL_DATE)) && FIM_.equals(LocalDate.parse(fim,DateTimeFormatter.ISO_LOCAL_DATE))){

                flag += 1;

            }

        }

        if(flag == 0){

            Promocao promocao = new Promocao(url, hotelCNPJ, preco, LocalDate.parse(inicio,DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.parse(fim,DateTimeFormatter.ISO_LOCAL_DATE));

            dao.insert(promocao);

            response.sendRedirect("listaPromocao");

        }

        else{

            response.sendRedirect("listaPromocao");

        }

    

    }
    
    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String url = request.getParameter("url");
        String hotel = request.getParameter("hotel");
        String preco = request.getParameter("preco");
        String inicio = request.getParameter("inicio");
        String fim = request.getParameter("fim");
        
        
        Promocao promocao = new Promocao(url, hotel, preco, LocalDate.parse(inicio,DateTimeFormatter.BASIC_ISO_DATE), LocalDate.parse(fim,DateTimeFormatter.BASIC_ISO_DATE));
        dao.update(promocao);
        response.sendRedirect("listaPromocao");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ID = request.getParameter("id");

        Promocao promocao = new Promocao(Long.parseLong(ID));
        dao.delete(promocao);
        response.sendRedirect("listaPromocao");
    }
    
}
