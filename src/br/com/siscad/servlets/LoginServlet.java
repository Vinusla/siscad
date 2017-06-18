package br.com.siscad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.siscad.entities.Aluno;
import br.com.siscad.entities.Autenticavel;
import br.com.siscad.entities.Professor;
import br.com.siscad.entities.Usuario;
import br.com.siscad.services.AutenticavelService;

public class LoginServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		if (login.equals("") || senha.equals("")) {
			response.sendRedirect("index.html");
			return;
		}
		Autenticavel usuario = AutenticavelService.efetuarLogin(login, senha);

		if (usuario == null) {			
			response.sendRedirect("index.html");
			return;
		}
		request.getSession().setAttribute("usuario", usuario);

		if (usuario != null) {
			if(usuario.getClass().isInstance(new Aluno())){
			 response.sendRedirect("listaMovimentacoes");
			}		
			else if(usuario.getClass().isInstance(new Professor())) {
			 response.sendRedirect("novaConta");
			}//else if(usuario.getClass().isInstance(new Adminstrador())) {
				// response.sendRedirect("adminConta");
		}

	}

}
