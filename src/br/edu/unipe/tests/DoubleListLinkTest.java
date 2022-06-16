package br.edu.unipe.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.unipe.domain.DoubleListLink;
import br.edu.unipe.models.Funcionario;

public class DoubleListLinkTest {
    private Funcionario funcionario;

    private  DoubleListLink listFuncionario;

    @BeforeEach
    void setUp(){
        funcionario = new Funcionario();
        DoubleListLink listLink = new DoubleListLink();
        listFuncionario = new DoubleListLink();

    }
    
    @Test
    @DisplayName("Funcionario Lista: Adicionando um novo funcionario no inicio da lista")
    public void addInit() {
        Funcionario func = new Funcionario();
        Funcionario func2 = new Funcionario();
        Funcionario funcionario = new Funcionario();
        
        func.setValorDoSalarioLiquido(1200);
        func2.setValorDoSalarioLiquido(400000);
        funcionario.setValorDoSalarioLiquido(760);
        
        listFuncionario.ordenarListaCrescenteSalario(func);
        listFuncionario.ordenarListaCrescenteSalario(func2);
        listFuncionario.ordenarListaCrescenteSalario(funcionario);
       

        assertEquals(760, listFuncionario.get(0).getValorDoSalarioLiquido());
        assertEquals(1200, listFuncionario.get(1).getValorDoSalarioLiquido());
        assertEquals(400000, listFuncionario.get(2).getValorDoSalarioLiquido());
        
        assertNotNull(listFuncionario.get(2).getValorDoSalarioLiquido());
        
        assertEquals(3, listFuncionario.size());
       

    }


    @Test
    @DisplayName("Funcionario Lista: remover um funcionario da lista")
    public void removeFuncionario() {
        listFuncionario.ordenarListaCrescenteSalario(funcionario);
        listFuncionario.remove(0);
        assertEquals(0, listFuncionario.size());
    }
    
    
    @Test
    @DisplayName("Funcionario lista: buscar nomes na lista")
    public void searchName() {
    	ArrayList<Funcionario> funcionarios = new ArrayList<>();
    	
    	Funcionario func = new Funcionario("oid",0,1200);
    	Funcionario func2 = new Funcionario("odin",0,2300);
    	Funcionario func3 = new Funcionario("orbe",0,4500);
        Funcionario funcionario = new Funcionario("teste",0,760);
          
        
        listFuncionario.ordenarListaCrescenteSalario(func);
        listFuncionario.ordenarListaCrescenteSalario(func2);
        listFuncionario.ordenarListaCrescenteSalario(func3);
        listFuncionario.ordenarListaCrescenteSalario(funcionario);
         
    	
    	funcionarios = listFuncionario.autocompleteNames("o",listFuncionario);
    	
    	assertEquals(3, funcionarios.size());
    	assertTrue(funcionarios.get(0).getNome().contains("o"));
    	assertTrue(funcionarios.get(1).getNome().contains("o"));
    	assertTrue(funcionarios.get(2).getNome().contains("o"));
       
    }
}
