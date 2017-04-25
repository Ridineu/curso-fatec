package fatec.poo.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author 0030481521033
 */
public class Cliente {
    private int Identificao;
    private String Cpf;
    private double Saldo;
    private ArrayList<Lancamento> lancamentos;   
    private DecimalFormat df = new DecimalFormat ("#,##0.00");
    
    public Cliente(int Identificao, String Cpf, double Saldo) {
        this.Identificao = Identificao;
        this.Cpf = Cpf;
        this.Saldo = Saldo;
        lancamentos = new ArrayList<>();
    }
            
    public void addLancamento(Lancamento lancamento){
        lancamento.setCliente(this);
        lancamentos.add(lancamento);        
        if(lancamento.getTipo().equals("C")){
            Saldo += lancamento.getValor();
        }else{
            Saldo -= lancamento.getValor();
        }
    }
    
    public void exibirLancamento(){
        System.out.println("\nCPF: " + Cpf);
        System.out.println("Saldo atual: " + df.format(Saldo));
        System.out.println("Lançamentos do cliente:");
        if(lancamentos.isEmpty()){
            System.out.println("Cliente não possui lançamentos\n");
        }else{
            for(int i=0; i<lancamentos.size(); i++){
                System.out.print("Código: " + lancamentos.get(i).getCodigo() + "\nTipo: ");
                if(lancamentos.get(i).getTipo().equals("C")){
                    System.out.println("Crédito");
                }else{
                    System.out.println("Débito");
                }
                System.out.println("Valor: " + df.format(lancamentos.get(i).getValor()) + "\n");
            }
        }
    }

    public String getCpf() {
        return Cpf;
    }   
}
