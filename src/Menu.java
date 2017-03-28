import java.io.IOException;
import java.util.Scanner;

import br.com.siscad.entities.Aluno;
import br.com.siscad.services.AlunoService;

public class Menu {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		int opt, opt2;
		
		Scanner scan= new Scanner(System.in);
		
		PrintMenuPrincipal();
		
		
		opt=scan.nextInt();
		
		while (opt!=0){
			
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
				}break;
				
				case 2:{
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
				    System.out.flush();  
				    PrintMenuProfessor();
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
		System.out.println("0- Sair");
	}
	
	public static void PrintMenuProfessor(){
		System.out.println("------Sistema acadêmico versão 0.01------");
		System.out.println("1- Cadastrar professor");
		System.out.println("2- Buscar professor");
		System.out.println("3- Atualizar professor");
		System.out.println("4- Excluir professor");
		System.out.println("0- Sair");
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
	
}
