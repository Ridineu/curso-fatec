package fatec.poo.model;

/**
 *
 * @author 0030481521022
 */
public class FuncionarioComissionado extends Funcionario{
    private double SalBase;
    private double TaxaComissao;
    private double TotalVendas;
    
    public FuncionarioComissionado(int r, String n, String dta, double txtc) {
        super(r, n, dta);
        TaxaComissao = txtc;
    }

    public double getSalBase() {
        return SalBase;
    }

    public double getTaxaComissao() {
        return TaxaComissao;
    }

    public double getTotalVendas() {
        return TotalVendas;
    }

    public void setSalBase(double SalBase) {
        this.SalBase = SalBase;
    }
    
    public void addVendas(double valv) {
        TotalVendas = TotalVendas + valv;
    }
    
    public double calcSalBruto() {
        return(SalBase + TaxaComissao * TotalVendas);
    }
    
    public double calcGratificacao() {
        if(TotalVendas <= 5000.00){
            return(0);
        } else {
            if(TotalVendas > 5000.00 && TotalVendas <= 10000.00) {
                return(calcSalBruto() * 0.03);
            } else {
                return(calcSalBruto() * 0.05);
            }
        }
    }
    
    public double calcSalLiquido() {
        return(calcSalBruto() - super.calcDesconto() + calcGratificacao());
    }
}
