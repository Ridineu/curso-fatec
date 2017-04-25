package fatec.poo.model;

/**
 *
 * @author 0030481521033
 */
public class Lancamento {
    private int codigo;
    private String tipo;
    private double valor;
    private Cliente cliente;
    
    public Lancamento(int codigo, String tipo, double valor) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
  
}
