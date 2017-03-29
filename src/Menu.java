import java.io.IOException;
import java.util.Scanner;

import br.com.siscad.entities.Aluno;
import br.com.siscad.entities.Curso;
import br.com.siscad.entities.Professor;
import br.com.siscad.services.AlunoService;
import br.com.siscad.services.CursoService;
import br.com.siscad.services.ProfessorService;

public class Menu {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		int opt=1, opt2;
		
		Scanner scan= new Scanner(System.in);
		
		PrintMenuPrincipal();
		
		while (opt!=0){
			
			opt=scan.nextInt();
			
			switch(opt){
				case 1:{
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				    System.out.flush();  
				    PrintMenuAluno();
				    opt2=scan.nextInt();
				    
				    if (opt2==1)
				    	CadAluno();
				    else if (opt2==2)
				    	BuscarAluno();
				    else if (opt2==3)
				    	AtualizarAluno();
				    else if (opt2==4)
				    	RemoverAluno();
				    else if (opt2==0){
				    	PrintMenuPrincipal();
				    	continue;
				    }
				}break;
				
				case 2:{
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				    System.out.flush();  
				    PrintMenuProfessor();
				    opt2=scan.nextInt();
				    
				    if (opt2==1)
				    	CadProfessor();
				    else if (opt2==2)
				    	BuscarProfessor();
				    else if (opt2==3)
				    	AtualizarProfessor();
				    else if (opt2==4)
				    	RemoverProfessor();
				    else if (opt2==5)
				    	InserirProfessorCurso();
				    else if (opt2==0){
				    	PrintMenuPrincipal();
				    	continue;
				    }
				    	
				}break;
				
				case 0:{
					System.exit(0);
				}break;
			}
			
		}
		
		
		

	}
	
	public static void PrintMenuPrincipal(){
		System.out.println("------Sistema acadêmico versão 0.01------");
		System.out.println("1- Gerenciar alunos");
		System.out.println("2- Gerenciar professores");
		System.out.println("0- Sair");
	}
	
	public static void PrintMenuAluno(){
		System.out.println("------Sistema acadêmico versão 0.01------");
		System.out.println("1- Cadastrar aluno");
		System.out.println("2- Buscar aluno");
		System.out.println("3- Atualizar aluno");
		System.out.println("4- Excluir aluno");
		System.out.println("0- Voltar");
	}
	
	public static void PrintMenuProfessor(){
		System.out.println("------Sistema acadêmico versão 0.01------");
		System.out.println("1- Cadastrar professor");
		System.out.println("2- Buscar professor");
		System.out.println("3- Atualizar professor");
		System.out.println("4- Excluir professor");
		System.out.println("5- Inserir professor em curso");
		System.out.println("0- Voltar");
	}
	
	
	public static void CadAluno(){
		Aluno aluno=new Aluno();
		
		Scanner form=new Scanner(System.in);
		System.out.println("Digite a matricula do aluno: ");
		String matricula=form.nextLine();
		aluno.setMatricula(matricula);
		System.out.println("Digite o nome do aluno: ");
		String nome=form.nextLine();
		aluno.setNome(nome);
		System.out.println("Digite a cidade do aluno: ");
		String cidade=form.nextLine();
		aluno.setCidade(cidade);
		
		AlunoService.MatriculaAluno(aluno);
		System.out.println("Aluno cadastrado com sucesso!");
		System.out.println("ID do aluno: "+aluno.getId());
		
	}
	
	public static void BuscarAluno(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID do aluno: ");
		Long id=form.nextLong();
		
		Aluno aluno=AlunoService.buscarAlunoPorId(id);
		
		System.out.println("Nome: "+aluno.getNome());
		
	}
	
	public static void AtualizarAluno(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID do aluno: ");
		Long id=Long.parseLong(form.nextLine());
		
		Aluno aluno=AlunoService.buscarAlunoPorId(id);
		
		System.out.println("Nome: "+aluno.getNome());
		
		System.out.println("Digite o novo nome do aluno: ");
		String nome=form.nextLine();
		aluno.setNome(nome);
		System.out.println("Digite a cidade do aluno: ");
		String cidade=form.nextLine();
		aluno.setCidade(cidade);
		
		AlunoService.AlterarAluno(aluno);
		System.out.println("Aluno alterado com sucesso!");
		
	}
	
	public static void RemoverAluno(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID do aluno: ");
		Long id=form.nextLong();
		
		Aluno aluno=AlunoService.buscarAlunoPorId(id);
		AlunoService.RemoverAluno(aluno);
		
		System.out.println("Aluno removido com sucesso!");
		
	}
	
	public static void CadProfessor(){
		Professor professor=new Professor();
		
		Scanner form=new Scanner(System.in);
		System.out.println("Digite a matricula do professor: ");
		String matricula=form.nextLine();
		professor.setMatricula(matricula);
		System.out.println("Digite o nome do professor: ");
		String nome=form.nextLine();
		professor.setNome(nome);
		System.out.println("Digite a cidade do professor: ");
		String cidade=form.nextLine();
		professor.setCidade(cidade);
		
		ProfessorService.CadastraProfessor(professor);
		System.out.println("Professor cadastrado com sucesso!");
		System.out.println("ID do professor: "+professor.getId());
		
	}
	
	public static void BuscarProfessor(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID do professor: ");
		Long id=form.nextLong();
		
		Professor professor=ProfessorService.buscarProfessorPorId(id);
		
		System.out.println("Nome: "+professor.getNome());
		
	}
	
	public static void AtualizarProfessor(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID do professor: ");
		Long id=Long.parseLong(form.nextLine());
		
		Professor professor=ProfessorService.buscarProfessorPorId(id);
		
		System.out.println("Nome: "+professor.getNome());
		
		System.out.println("Digite o novo nome do professor: ");
		String nome=form.nextLine();
		professor.setNome(nome);
		System.out.println("Digite a cidade do professor: ");
		String cidade=form.nextLine();
		professor.setCidade(cidade);
		
		ProfessorService.AlterarProfessor(professor);
		System.out.println("Professor alterado com sucesso!");
		
	}
	
	public static void RemoverProfessor(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID do professor: ");
		Long id=form.nextLong();
		
		Professor professor=ProfessorService.buscarProfessorPorId(id);
		ProfessorService.RemoverProfessor(professor);
		
		System.out.println("Professor removido com sucesso!");
		
	}
	
	public static void InserirProfessorCurso(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID do professor: ");
		Long id=Long.parseLong(form.nextLine());
		Professor professor=ProfessorService.buscarProfessorPorId(id);
		
		System.out.println("Digite o ID do curso ao qual você deseja acrescentar o professor: ");
		Long id2=Long.parseLong(form.nextLine());
		Curso curso=CursoService.buscarCurso(id2);
		
		CursoService.inserirProfessorCurso(professor, curso);
		System.out.println("Professor alterado com sucesso!");
		
	}
	
}
