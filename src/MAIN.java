import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.entities.Curso;
import br.com.siscad.entities.Disciplina;
import br.com.siscad.entities.Professor;
import br.com.siscad.services.CursoService;
import br.com.siscad.services.ProfessorService;


public class MAIN {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("siscad");
		
		EntityManager manager = emf.createEntityManager();
		
		/*Professor p = new Professor();
		p.setNome("tese");
		
		ProfessorService.CadastraProfessor(p);
		*/
		Curso c = new Curso();
		c.setNome("contabilidade");
		CursoService.CadastrarCurso(c);
		
		//CursoService.inserirProfessorCurso(p, c);
		
		
		Disciplina d = new Disciplina();
		d.setNome("matemetica");
		

		List<Disciplina> disc = new ArrayList<>();
		
		Disciplina d1 = new Disciplina();
		d.setNome("portugues");
		
		d.setCurso(c);
		d1.setCurso(c);
		
		disc.add(d);
		disc.add(d1);
		
		c.setDisciplinas(disc);
		
				

	}

}
