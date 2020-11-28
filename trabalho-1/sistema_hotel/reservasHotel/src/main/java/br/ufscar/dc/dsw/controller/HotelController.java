package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.domain.Hotel;
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


//Alterar os argumentos para ficar correto em relação ao hotel
@WebServlet(urlPatterns = "/hotels/*")
public class HotelController extends HttpServlet {

    private static final long serialVersionUID = 1L; 
    private HotelDAO dao;

    @Override
    public void init() {
        dao = new HotelDAO();
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
                /*
                case "/remocao":
                    remove(request, response);
                    break;
                //case "/edicao":
                    //apresentaFormEdicao(request, response);
                    //break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                    */
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
        request.setAttribute("listaHotels", listaHotels);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/lista.jsp");
        dispatcher.forward(request, response);
    }
    /*
    private Map<Long, String> getEditoras() {
        Map <Long,String> editoras = new HashMap<>();
        for (Editora editora: new EditoraDAO().getAll()) {
            editoras.put(editora.getId(), editora.getNome());
        }
        return editoras;
    }
    */
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/cadastroHotel.jsp");
        dispatcher.forward(request, response);
    }
    /*
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Hotel hotel = dao.get(id);
        request.setAttribute("hotel", hotel);
        request.setAttribute("editoras", getEditoras());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hotel/formulario.jsp");
        dispatcher.forward(request, response);
    }
    */
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String CNPJ = request.getParameter("cnpj");

        Hotel hotel = new Hotel(email, senha, CNPJ, nome, cidade);
        dao.insert(hotel);
        response.sendRedirect("lista");
    }
    /*
    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String CNPJ = request.getParameter("cnpj");

        Hotel hotel = new Hotel(email, senha, CNPJ, nome, cidade);
        dao.update(hotel);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String CNPJ = request.getParameter("cnpj");

        Hotel hotel = new Hotel(CNPJ);
        dao.delete(hotel);
        response.sendRedirect("lista");
    }
    */
}