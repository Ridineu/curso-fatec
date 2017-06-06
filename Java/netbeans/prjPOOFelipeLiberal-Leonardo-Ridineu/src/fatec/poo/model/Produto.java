package fatec.poo.model;

public class Produto{
    private int codigo, qtdeDisponivel, estoqueMin;
    private String descricao;
    private double precoUnit;

    public Produto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public int getQtdeDisponivel() {
        return qtdeDisponivel;
    }

    public void setQtdeDisponivel(int qtdeDisponivel) {
        this.qtdeDisponivel = qtdeDisponivel;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(int estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }    
    
}