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
        itempedido.atualizaEstoque();
        cliente.attLimitDisp(itempedido.calcCustoItem());
    }

    public void setItensPedido(ArrayList<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
       
    public double calcCustoTotal(){
        double custoTotal=0;
        
        for(int i=0; i<itensPedido.size(); i++){
            custoTotal += itensPedido.get(i).calcCustoItem();
        }
        
        return custoTotal;
    }
}