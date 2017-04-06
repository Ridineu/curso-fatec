package fatec.poo.model;


import fatec.poo.model.Pessoa;


public class PessoaJuridica extends Pessoa{
    
    private String CGC;   
    private double taxaIncentivo;
    
    public PessoaJuridica(String CGC, String nome, int ano){
        super(nome, ano);
        this.CGC = CGC;
    }
    
    public double calcBonus(int ano){
        return super.getTotalCompras() * taxaIncentivo * (ano - super.getAnoInscricao());
    }
    
    public String getCGC() {
        return CGC;
    }

    public double getTaxaIncentivo() {
        return taxaIncentivo;
    }
    
    public void setTaxaIncentivo(double taxaIncentivo) {
        this.taxaIncentivo = taxaIncentivo;
    }
}
