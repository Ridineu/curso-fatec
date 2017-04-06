package fatec.poo.model;

public class PessoaFisica extends Pessoa{

  private String CPF;
  private double base;
  
  public PessoaFisica(String CPF, String nome, int ano){
      super(nome, ano);
      this.CPF = CPF;
  }
  
  public double calcBonus(int ano){
      if(super.getTotalCompras() > 12000){
          return (ano - super.getAnoInscricao()) * base;
      }
      return 0;      
  }
  
  public String getCPF(){
      return CPF;
  }
  
  public void setBase(double base){
      this.base = base;
  }
  
  public double getBase(){
      return base;
  }
}
