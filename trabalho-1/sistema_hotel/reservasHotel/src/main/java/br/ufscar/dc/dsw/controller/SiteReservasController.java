package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.SiteReservasDAO;
import br.ufscar.dc.dsw.domain.SiteReservas;
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

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.UsuarioDAO;


//Alterar os argumentos para ficar correto em relação ao Site
@WebServlet(urlPatterns = "/sites/*")
public class SiteReservasController extends HttpServlet {

    private static final long serialVersionUID = 1L; 
    private SiteReservasDAO dao;
    private UsuarioDAO userDao;

    @Override
    public void init() {
        dao = new SiteReservasDAO();
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
            
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SiteReservas> listaSiteReservas = dao.getAll();
        request.setAttribute("listaSiteReservas", listaSiteReservas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/site/listaSiteReservas.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/site/cadastroSiteReservas.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String URL = request.getParameter("url");
        SiteReservas site = dao.getbyURL(URL);
        request.setAttribute("site", site);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/site/edicaoSiteReservas.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String url = request.getParameter("url");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");

        SiteReservas site = new SiteReservas(email, senha, url, nome, telefone);
        dao.insert(site);

        String papel = "SITE";

        Usuario user = new Usuario(nome, email, senha, papel);
        userDao.insert(user);
        response.sendRedirect("listaSiteReservas");
    }
    
    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String url = request.getParameter("url");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");

        SiteReservas site = new SiteReservas(email, senha, url, nome, telefone);
        dao.update(site);
        response.sendRedirect("listaSiteReservas");
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getParameter("url");

        SiteReservas site = new SiteReservas(url);
        dao.delete(site);
        response.sendRedirect("listaSiteReservas");
    }
    
}