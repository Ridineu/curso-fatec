package fatec.poo.model;

/**
 *
 * @author 0030481521022
 */
public class FuncionarioMensalista extends Funcionario{
    private double ValSalMin;
    private double NumSalMin;
    
    public FuncionarioMensalista(int r, String n, String dta, double nsm) {
        super(r, n, dta);
        NumSalMin = nsm;
    }
    
    public void apontarValSalMin(double vsm) {
        ValSalMin = vsm;
    }
    
    public double calcSalBruto() {
        double SalBruto;
        SalBruto = NumSalMin * ValSalMin;
        return(SalBruto);
    }
    
}
