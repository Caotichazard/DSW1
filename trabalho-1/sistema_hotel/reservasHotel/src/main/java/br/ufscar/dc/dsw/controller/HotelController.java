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


import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.UsuarioDAO;

//Alterar os argumentos para ficar correto em relação ao hotel
@WebServlet(urlPatterns = "/hotels/*")
public class HotelController extends HttpServlet {

    private static final long serialVersionUID = 1L; 
    private HotelDAO dao;
    private UsuarioDAO userDao;

    @Override
    public void init() {
        dao = new HotelDAO();
        userDao = new UsuarioDAO();
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
                case "/cidade":
                    cidade(request,response);
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
        List<Hotel> listaHotels = dao.getAll();
        List<String> listaCidades = dao.getCidades();
        request.setAttribute("listaHotels", listaHotels);
        request.setAttribute("listaCidades", listaCidades);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/listaHotels.jsp");
        dispatcher.forward(request, response);
    }
    private void cidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cidade = request.getParameter("cidade");
        List<Hotel> listaHotels = dao.getbyCidade(cidade);
        List<String> listaCidades = dao.getCidades();
        request.setAttribute("listaCidades", listaCidades);
        request.setAttribute("listaHotels", listaHotels);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/listaHotels.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/cadastroHotel.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CNPJ = request.getParameter("cnpj");
        Hotel hotel = dao.getbyCNPJ(CNPJ);
        request.setAttribute("hotel", hotel);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/edicaoHotel.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String CNPJ = request.getParameter("cnpj");

        Hotel hotel = new Hotel(email, senha, CNPJ, nome, cidade);
        dao.insert(hotel);

        String papel = "HOTEL";

        Usuario user = new Usuario(nome, email, senha, papel);
       
        userDao.insert(user);

        response.sendRedirect("listaHotel");
    }
    
    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String CNPJ = request.getParameter("cnpj");

        Hotel hotel = new Hotel(email, senha, CNPJ, nome, cidade);
        dao.update(hotel);
        response.sendRedirect("listaHotel");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String CNPJ = request.getParameter("cnpj");

        Hotel hotel = new Hotel(CNPJ);
        dao.delete(hotel);
        response.sendRedirect("listaHotel");
    }
    
}