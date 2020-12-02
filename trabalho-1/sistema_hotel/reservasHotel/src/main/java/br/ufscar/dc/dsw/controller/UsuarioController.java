package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/logins/*")
public class UsuarioController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UsuarioDAO dao;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*
    	Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
    	Erro erros = new Erro();    	
    	if (usuario == null) {
    		response.sendRedirect(request.getContextPath());
    	} else if (usuario.getPapel().equals("USER")) {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/usuario/index.jsp");
            dispatcher.forward(request, response);
    	} else {
    		erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [USER] tem acesso a essa página");
    		request.setAttribute("mensagens", erros);
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    		rd.forward(request, response);
		}  */
		
		String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "/login":
                    apresentaFormLogin(request, response);
                    break;
                case "/entry":
                    entry(request, response);
                    break;
				
                
            
                default:
					apresentaFormLogin(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
	}

	private void entry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Erro erros = new Erro();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		if (login == null || login.isEmpty()) {
			erros.add("Login não informado!");
		}
		if (senha == null || senha.isEmpty()) {
			erros.add("Senha não informada!");
		}
		if (!erros.isExisteErros()) {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = dao.getbyLogin(login);
			if (usuario != null) {
				if (usuario.getSenha().equals(senha)) {
					request.getSession().setAttribute("usuarioLogado", usuario);
					response.sendRedirect(request.getContextPath());
					return;
				} else {
					erros.add("Senha inválida!");
				}
			} else {
				erros.add("Usuário não encontrado!");
			}
		}
		
		request.getSession().invalidate();
		request.setAttribute("mensagens", erros);
		String URL = "/login/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);
    }
    
    private void apresentaFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
        dispatcher.forward(request, response);
    }
	

}