import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.entities.Curso;
import br.com.siscad.entities.Professor;
import br.com.siscad.services.CursoService;
import br.com.siscad.services.ProfessorService;


public class MAIN {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("siscad");
		
		EntityManager manager = emf.createEntityManager();
		
		Professor p = new Professor();
		p.setNome("tese");
		
		ProfessorService.CadastraProfessor(p);
		
		Curso c = new Curso();
		c.setNome("ciencia");
		CursoService.CadastrarCurso(c);
		
		CursoService.inserirProfessorCurso(p, c);
		
				

	}

}
