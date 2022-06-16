package br.edu.unipe.domain;

import br.edu.unipe.models.Funcionario;

public enum CalcularImposto {

   DEZ_PORCENTO_IMPOSTO{

    @Override
    public Funcionario calculateSalario(Funcionario funcionario) {
        double valuePercente = funcionario.getValorDoSalarioBruto() * 0.10;
        double valorDoSalarioLiquido = funcionario.getValorDoSalarioBruto() - valuePercente;
        funcionario.setValorDoSalarioLiquido(valorDoSalarioLiquido);
        return funcionario;
        
    }

   },

   VINTE_PORCENTO_IMPOSTO{

    @Override
    public Funcionario calculateSalario(Funcionario funcionario) {
        double valuePercente = funcionario.getValorDoSalarioBruto() * 0.20;
        double valorDoSalarioLiquido = funcionario.getValorDoSalarioBruto() - valuePercente;
        funcionario.setValorDoSalarioLiquido(valorDoSalarioLiquido);
        return funcionario;
    }

   };

   public abstract Funcionario calculateSalario(Funcionario funcionario);
}
