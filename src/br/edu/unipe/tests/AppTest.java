package br.edu.unipe.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.unipe.domain.DoubleListLink;
import br.edu.unipe.main.App;
import br.edu.unipe.models.Funcionario;

public class AppTest {

    @Test
    @DisplayName("Calculando o imposto")
    public void addFuncionario(){
        Funcionario func = new Funcionario();
        Funcionario funcionario = new Funcionario();
        
        func.setValorDoSalarioBruto(1600);
        funcionario.setValorDoSalarioBruto(1199);
        
        App app = new App();
        
        Funcionario funcionario2 = app.calcularImposto(func);
        assertEquals(1280, funcionario2.getValorDoSalarioLiquido());
    }
    
    @Test
    @DisplayName("Inserindo um novo funcionario")
    public void inserirFuncionario() {
    	
    	DoubleListLink listLink = new DoubleListLink();
    	Funcionario func = new Funcionario("sad",0,1600);
        Funcionario funcionario = new Funcionario("rer",0,1199);
        Funcionario funcionario2 = new Funcionario("wrw",0,750);
        
        App app = new App();
        
        func = app.calcularImposto(func);
        funcionario = app.calcularImposto(funcionario);
        
        listLink.ordenarListaCrescenteSalario(func);
        listLink.ordenarListaCrescenteSalario(funcionario);
        listLink.ordenarListaCrescenteSalario(funcionario2);
        
        assertEquals(750, listLink.get(0).getValorDoSalarioLiquido());
        
    }

}
