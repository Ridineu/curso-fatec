package fatec.poo.model;

public abstract class Pessoa {
    
    private String nome;
    private int anoInscricao;
    private double totalCompras;
    
    public Pessoa(String nome, int anoInscricao){
        this.nome = nome;
        this.anoInscricao = anoInscricao;
        this.totalCompras = 0;
    }
    
    abstract public double calcBonus(int ano);    
    
    public void addCompras(double valorCompra){
        this.totalCompras += valorCompra;
    }
    
    public String getNome() {
        return nome;
    }

    public int getAnoInscricao() {
        return anoInscricao;
    }

    public double getTotalCompras() {
        return totalCompras;
    }
}
