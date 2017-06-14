package fatec.poo.model;

public class ItemPedido{
    private int numeroItem, qtdeVendida;
    private Produto produto;
    private Pedido pedido;

    public ItemPedido(int numeroItem, int qtdeVendida) {
        this.numeroItem = numeroItem;
        this.qtdeVendida = qtdeVendida;
    }

    public int getNumeroItem() {
        return numeroItem;
    }

    public int getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(int qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;       
    }
    
    public Pedido getPedido(){
        return pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }    
    
    public void atualizaEstoque(){
	produto.setQtdeDisponivel(produto.getQtdeDisponivel() - qtdeVendida);		
    }
    
    public double calcCustoItem(){
       return (qtdeVendida * produto.getPrecoUnit());
    }
       
    public boolean a(ItemPedido itempedido){
        return true;
    }
}