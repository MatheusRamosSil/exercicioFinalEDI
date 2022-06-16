package br.edu.unipe.models;


public class Funcionario {

    private String nome;
    private double valorDoSalarioBruto;
    private double valorDoSalarioLiquido;

    
    public Funcionario() {
    }


    public Funcionario(String nome, double valorDoSalarioBruto, double valorDoSalarioLiquido) {
        this.nome = nome;
        this.valorDoSalarioBruto = valorDoSalarioBruto;
        this.valorDoSalarioLiquido = valorDoSalarioLiquido;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getValorDoSalarioBruto() {
        return valorDoSalarioBruto;
    }


    public void setValorDoSalarioBruto(double valorDoSalarioBruto) {
        this.valorDoSalarioBruto = valorDoSalarioBruto;
    }


    public double getValorDoSalarioLiquido() {
        return valorDoSalarioLiquido;
    }


    public void setValorDoSalarioLiquido(double valorDoSalarioLiquido) {
        this.valorDoSalarioLiquido = valorDoSalarioLiquido;
    }

    

    
}
