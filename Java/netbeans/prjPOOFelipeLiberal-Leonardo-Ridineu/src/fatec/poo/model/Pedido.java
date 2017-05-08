package fatec.poo.model;

import java.util.ArrayList;

public class Pedido{
    private int Numero;
    private String dataEmissaoPedido, dataPagto;
    private boolean status; 
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<ItemPedido> itensPedido;

    public Pedido(int Numero, String dataEmissaoPedido) {
        this.Numero = Numero;
        this.dataEmissaoPedido = dataEmissaoPedido;
        itensPedido = new ArrayList<>();
    }

    public String getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getNumero() {
        return Numero;
    }

    public String getDataEmissaoPedido() {
        return dataEmissaoPedido;
    }

    public ArrayList<ItemPedido> getItensPedido() {
        return itensPedido;
    }
    
    public void addItemPedido(ItemPedido itempedido){
        itensPedido.add(itempedido);
        itempedido.setPedido(this);
        cliente.setLimiteDisp(cliente.getLimiteDisp() -
                (itempedido.getProduto().getPrecoUnit() * itempedido.getQtdeVendida()));
    }
}