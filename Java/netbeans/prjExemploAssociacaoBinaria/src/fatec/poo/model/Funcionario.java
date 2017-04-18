package fatec.poo.model;

/**
 *
 * @author 0030481521033
 */
public abstract class Funcionario {
    private int Registro;
    private String Nome;
    private String DtAdmissao;
    private String Cargo;
    private Departamento departamento;
    private Projeto projeto;
    
    public Funcionario(int r, String n, String dta) {
        Registro = r;
        Nome = n;
        DtAdmissao = dta;
    }
    
    abstract public double calcSalBruto();
    
    public double calcDesconto() {
        double Desconto;
        Desconto = 0.10 * calcSalBruto();
        return(Desconto);
    }
    
    public double calcSalLiquido() {
        double SalLiq;
        SalLiq = calcSalBruto() - calcDesconto();
        return(SalLiq);
    }
    
    public int getRegistro() {
        return(Registro);
    }
    
    public String getNome() {
        return(Nome);
    }
    
    public String getDtAdmissao() {
        return(DtAdmissao);
    }
    
    public String getCargo() {
        return(Cargo);
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    } 
    
}
