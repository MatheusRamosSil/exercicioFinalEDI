package br.edu.unipe.main;

import java.util.ArrayList;

import br.edu.unipe.domain.CalcularImposto;
import br.edu.unipe.domain.DoubleListLink;
import br.edu.unipe.models.DoubleNode;
import br.edu.unipe.models.Funcionario;

public class App {
	
	static InputKeyboard inputKeyboard = new InputKeyboard();
	static DoubleListLink listFuncinario = new DoubleListLink();
    
	public static void main(String[] args) throws Exception {
    	initProgram();
    }

	private static void initProgram() {
		
		 addFuncionariosInList();
		 printAllFuncionarios(listFuncinario);
		 buscarFuncionarioPeloNome();
	}


	private static void buscarFuncionarioPeloNome() {
		System.out.println();
		
		showMessage("Quer procurar uma usuario pelo  nome ou letra?");
		showMessage("(s)SIM ou (n)NÃO");
		String opcao = inputKeyboard.getInputString();
		
		if(opcao.equalsIgnoreCase("s")) {
			do {
				showMessage("Digite o nome ou primeira letra:");
				String nomeASerProcurado = inputKeyboard.getInputString();
				ArrayList<Funcionario> listaDeBuscaFuncionarios = listFuncinario.autocompleteNames(nomeASerProcurado, listFuncinario);
				
				mostrarListaDeBusca(listaDeBuscaFuncionarios);
				
				System.out.println();
				showMessage("Quer procurar uma usuario pelo  nome ou letra?");
				showMessage("(s)SIM ou (n)NÃO");
				opcao = inputKeyboard.getInputString();
				
			} while (!opcao.equalsIgnoreCase("n"));
			
		}
		
	}

	private static void mostrarListaDeBusca(ArrayList<Funcionario> funcionarios) {
		System.out.println();
		for(Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getNome()+"\t"+funcionario.getValorDoSalarioLiquido());
		}
		
	}

	private static void printAllFuncionarios(DoubleListLink listLink) {
		System.out.println();
		System.out.println("FUNCIONARIO\tSALARIO");
		for(int i = 0; i < listLink.size(); i++) {
			System.out.println(listLink.get(i).getNome()+"\t\t"+listLink.get(i).getValorDoSalarioLiquido());
		}
		
	}

	private static void  addFuncionariosInList() {
		
		 for(int i = 0; i < 4; i++) {
			 Funcionario funcionario = new Funcionario();
			 
			 showMessage("Adicione o nome do funcionario:");
			 funcionario.setNome(inputKeyboard.getInputString()); 
			 
			 showMessage("Adicione o salario bruto:");
			 funcionario.setValorDoSalarioBruto(inputKeyboard.getInputDouble());
			 
				
			 funcionario = calcularImposto(funcionario);
			 listFuncinario.ordenarListaCrescenteSalario(funcionario);
		 }
		
	}

	private static void showMessage(String message) {
		System.out.println(message);	
	}

	public static Funcionario calcularImposto(Funcionario funcionario) {
		if (funcionario.getValorDoSalarioBruto() >= 1200) {
			return CalcularImposto.VINTE_PORCENTO_IMPOSTO.calculateSalario(funcionario);
		}
		                                                  
		if (funcionario.getValorDoSalarioBruto() > 850) {
			 return  CalcularImposto.DEZ_PORCENTO_IMPOSTO.calculateSalario(funcionario);
		}
		
		funcionario.setValorDoSalarioLiquido(funcionario.getValorDoSalarioBruto());
		return funcionario;
	}

}
