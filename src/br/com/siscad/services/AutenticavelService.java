package br.com.siscad.services;

import br.com.siscad.dao.AlunoDAO;
import br.com.siscad.dao.ProfessorDAO;
import br.com.siscad.entities.Autenticavel;

public class AutenticavelService {

	public static Autenticavel efetuarLogin(String login, String senha) {

		Autenticavel usuario = null;

		AlunoDAO alunoDao = new AlunoDAO();
		usuario = alunoDao.efetuaLogin(login, senha);

		if (usuario == null) {
			ProfessorDAO professorDao = new ProfessorDAO();
			usuario = professorDao.efetuaLogin(login, senha);

		}

		return usuario;

	}

}
