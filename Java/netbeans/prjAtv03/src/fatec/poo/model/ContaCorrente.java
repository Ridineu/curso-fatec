package fatec.poo.model;

public class ContaCorrente {
    private int numero;
    private double saldo;
    
    public ContaCorrente(int numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }
    
    public void depositar(double valor){
        saldo += valor;
    }
    
    public void sacar(double valor){
        saldo -= valor;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public double getSaldo(){
        return saldo;
    }
}
