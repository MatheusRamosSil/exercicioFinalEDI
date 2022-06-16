package br.edu.unipe.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.unipe.domain.CalcularImposto;
import br.edu.unipe.models.Funcionario;

public class CalcularImpostoTest {
    
    private Funcionario funcionario;

    @BeforeEach
    void setUp(){
        funcionario = new Funcionario();
        funcionario.setValorDoSalarioBruto(1200);
    }

    @Test
    @DisplayName("Calcular salario final do funcionario")
    public void calcularSalario(){
        Funcionario result = CalcularImposto.DEZ_PORCENTO_IMPOSTO.calculateSalario(funcionario);
        assertEquals(1080, result.getValorDoSalarioLiquido());
    }

}
