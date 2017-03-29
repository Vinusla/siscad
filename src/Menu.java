import java.io.IOException;
import java.util.Scanner;

import br.com.siscad.entities.Aluno;
import br.com.siscad.entities.Curso;
import br.com.siscad.entities.Disciplina;
import br.com.siscad.entities.Professor;
import br.com.siscad.entities.Turma;
import br.com.siscad.services.AlunoService;
import br.com.siscad.services.CursoService;
import br.com.siscad.services.DisciplinaService;
import br.com.siscad.services.ProfessorService;
import br.com.siscad.services.TurmaService;

public class Menu {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		int opt=1, opt2;
		
		Scanner scan= new Scanner(System.in);
		
		while (LoginUser()==false){
			
		}
		
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
				
				case 3:{
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				    System.out.flush();  
				    PrintMenuCurso();
				    opt2=scan.nextInt();
				    
				    if (opt2==1)
				    	CadCurso();
				    else if (opt2==2)
				    	BuscarCurso();
				    else if (opt2==3)
				    	AtualizarCurso();
				    else if (opt2==4)
				    	RemoverCurso();
				    else if (opt2==0){
				    	PrintMenuPrincipal();
				    	continue;
				    }
				}break;
				    
				case 4:{
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				    System.out.flush();  
				    PrintMenuDisciplina();
				    opt2=scan.nextInt();
				    
				    if (opt2==1)
				    	CadDisciplina();
				    else if (opt2==2)
				    	BuscarDisciplina();
				    else if (opt2==3)
				    	AtualizarDisciplina();
				    else if (opt2==4)
				    	RemoverDisciplina();
				    else if (opt2==0){
				    	PrintMenuPrincipal();
				    	continue;
				    }
				    	
				}break;
				
				case 5:{
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				    System.out.flush();  
				    PrintMenuTurma();
				    opt2=scan.nextInt();
				    
				    if (opt2==1)
				    	CadTurma();
				    else if (opt2==2)
				    	BuscarTurma();
				    else if (opt2==3)
				    	AtualizarTurma();
				    else if (opt2==4)
				    	RemoverTurma();
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
		System.out.println("3- Gerenciar cursos");
		System.out.println("4- Gerenciar disciplinas");
		System.out.println("5- Gerenciar turmas");
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
	
	public static void PrintMenuCurso(){
		System.out.println("------Sistema acadêmico versão 0.01------");
		System.out.println("1- Cadastrar curso");
		System.out.println("2- Buscar curso");
		System.out.println("3- Atualizar curso");
		System.out.println("4- Excluir curso");
		System.out.println("0- Voltar");
	}
	
	public static void PrintMenuDisciplina(){
		System.out.println("------Sistema acadêmico versão 0.01------");
		System.out.println("1- Cadastrar disciplina");
		System.out.println("2- Buscar disciplina");
		System.out.println("3- Atualizar disciplina");
		System.out.println("4- Excluir disciplina");
		System.out.println("0- Voltar");
	}
	
	public static void PrintMenuTurma(){
		System.out.println("------Sistema acadêmico versão 0.01------");
		System.out.println("1- Cadastrar turma");
		System.out.println("2- Buscar turma");
		System.out.println("3- Atualizar turma");
		System.out.println("4- Excluir turma");
		System.out.println("0- Voltar");
	}
	
	public static boolean LoginUser(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o login do usuário: ");
		String login=form.nextLine();
		
		Aluno aluno=AlunoService.buscarAlunoPorLogin(login);
		
		if (aluno==null){
			System.out.println("Usuário não cadastrado!");
			return false;
		}
		
		System.out.println("Digite a senha do usuário: ");
		String senha=form.nextLine();
		
		if (aluno.getSenha().equals(senha))
			return true;
		else{
			System.out.println("Senha incorreta!");
			return false;
		}
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
		System.out.println("Digite o login do aluno: ");
		String login=form.nextLine();
		aluno.setLogin(login);
		System.out.println("Digite a senha do aluno: ");
		String senha=form.nextLine();
		aluno.setSenha(senha);
		
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
	
	public static void CadCurso(){
		Curso curso=new Curso();
		
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o nome do curso: ");
		String nome=form.nextLine();
		curso.setNome(nome);
		System.out.println("Digite o tipo do curso: ");
		String tipo=form.nextLine();
		curso.setTipo(tipo);
		
		CursoService.CadastrarCurso(curso);
		System.out.println("Curso cadastrado com sucesso!");
		System.out.println("ID do curso: "+curso.getId());
		
	}
	
	public static void BuscarCurso(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID do curso: ");
		Long id=form.nextLong();
		
		Curso curso=CursoService.buscarCurso(id);
		
		System.out.println("Nome: "+curso.getNome());
		
	}
	
	public static void AtualizarCurso(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID do curso: ");
		Long id=Long.parseLong(form.nextLine());
		
		Curso curso=CursoService.buscarCurso(id);
		
		System.out.println("Nome: "+curso.getNome());
		
		System.out.println("Digite o novo nome do curso: ");
		String nome=form.nextLine();
		curso.setNome(nome);
		System.out.println("Digite o novo tipo do curso: ");
		String tipo=form.nextLine();
		curso.setTipo(tipo);
		
		CursoService.AlterarCurso(curso);
		System.out.println("Curso alterado com sucesso!");
		
	}
	
	public static void RemoverCurso(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID do curso: ");
		Long id=form.nextLong();
		
		Curso curso=CursoService.buscarCurso(id);
		CursoService.RemoverCurso(curso);
		
		System.out.println("Curso removido com sucesso!");
		
	}
	
	public static void CadDisciplina(){
		Disciplina disciplina=new Disciplina();
		
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o nome da disciplina: ");
		String nome=form.nextLine();
		disciplina.setNome(nome);
		System.out.println("Digite a área da disciplina: ");
		String area=form.nextLine();
		disciplina.setArea(area);
		
		DisciplinaService.CadastrarDisciplina(disciplina);
		System.out.println("Disciplina cadastrado com sucesso!");
		System.out.println("ID da disciplina: "+disciplina.getId());
		
	}
	
	public static void BuscarDisciplina(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID da disciplina: ");
		Long id=form.nextLong();
		
		Disciplina disciplina=DisciplinaService.buscarDisciplinaPorId(id);
		
		System.out.println("Nome: "+disciplina.getNome());
		
	}
	
	public static void AtualizarDisciplina(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID da disciplina: ");
		Long id=Long.parseLong(form.nextLine());
		
		Disciplina disciplina=DisciplinaService.buscarDisciplinaPorId(id);
		
		System.out.println("Nome: "+disciplina.getNome());
		
		System.out.println("Digite o novo nome da disciplina: ");
		String nome=form.nextLine();
		disciplina.setNome(nome);
		System.out.println("Digite a nova área da disciplina: ");
		String area=form.nextLine();
		disciplina.setArea(area);
		
		DisciplinaService.AlterarDisciplina(disciplina);
		System.out.println("Curso alterado com sucesso!");
		
	}
	
	public static void RemoverDisciplina(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID da disciplina: ");
		Long id=form.nextLong();
		
		Disciplina disciplina=DisciplinaService.buscarDisciplinaPorId(id);
		DisciplinaService.RemoverDisciplina(disciplina);
		
		System.out.println("Disciplina removida com sucesso!");
		
	}
	
	public static void CadTurma(){
		Turma turma=new Turma();
		
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o semestre da turma: ");
		String semestre=form.nextLine();
		turma.setSemestre(semestre);
		System.out.println("Digite o ano da turma: ");
		int ano=Integer.parseInt(form.nextLine());
		turma.setAno(ano);
		
		TurmaService.CadastrarTurma(turma);
		System.out.println("Disciplina cadastrado com sucesso!");
		System.out.println("ID da disciplina: "+turma.getId());
		
	}
	
	public static void BuscarTurma(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID da turma: ");
		Long id=form.nextLong();
		
		Turma turma=TurmaService.buscarTurma(id);
		
		System.out.println("Nome: "+turma.getAno()+"."+turma.getSemestre());
		
	}
	
	public static void AtualizarTurma(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID da disciplina: ");
		Long id=Long.parseLong(form.nextLine());
		
		Turma turma=TurmaService.buscarTurma(id);
		
		System.out.println("Nome: "+turma.getAno()+"."+turma.getSemestre());
		
		System.out.println("Digite o novo semestre da turma: ");
		String semestre=form.nextLine();
		turma.setSemestre(semestre);
		System.out.println("Digite o novo ano da turma: ");
		int ano=Integer.parseInt(form.nextLine());
		turma.setAno(ano);
		
		TurmaService.AlterarTurma(turma);
		System.out.println("Turma alterada com sucesso!");
		
	}
	
	public static void RemoverTurma(){
		Scanner form=new Scanner(System.in);
		System.out.println("Digite o ID da turma: ");
		Long id=form.nextLong();
		
		Turma turma=TurmaService.buscarTurma(id);
		TurmaService.RemoverTurma(turma);
		
		System.out.println("Turma removida com sucesso!");
		
	}
	
}
