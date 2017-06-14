package fatec.poo.model;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private double limiteCred, limiteDisp;
    private ArrayList<Pedido> pedidos;
    
    public Cliente(String cpf, String nome, double limiteCred) {
        super(cpf, nome);
        this.limiteDisp = this.limiteCred = limiteCred;
        pedidos = new ArrayList<Pedido>();
    }
    
    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
        pedido.setCliente(this);
    }

    public double getLimiteCred() {
        return limiteCred;
    }

    public double getLimiteDisp() {
        return limiteDisp;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    } 

    public void attLimitDisp(double valor){
        this.limiteDisp -= valor;
    }

    public void setLimiteCred(double limiteCred) {
        this.limiteDisp = this.limiteCred = limiteCred;
    }

    public void setLimiteDisp(double limiteDisp) {
        this.limiteDisp = limiteDisp;
    }
    
    
}
    