package fatec.poo.model;

public class FuncionarioMensalista extends Funcionario{
    private double ValSalMin;
    private double NumSalMin;

    public FuncionarioMensalista(int r, String n, String dta, double nsm) {
        super(r, n, dta);//chamada do método construtor
                         //da super classe Funcionario
        NumSalMin = nsm;
    }

    public void apontarValSalMin(double vsm) {
       ValSalMin = vsm;
    }

    
    public double calcSalBruto() {
        return(NumSalMin * ValSalMin);
    }
    
    
}
