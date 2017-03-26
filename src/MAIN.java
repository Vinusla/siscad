import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.entities.Aluno;


public class MAIN {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("siscad");
		
		EntityManager manager = emf.createEntityManager();
		
				

	}

}
