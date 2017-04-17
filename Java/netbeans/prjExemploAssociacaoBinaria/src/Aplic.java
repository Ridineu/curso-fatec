
import fatec.poo.model.Departamento;
import fatec.poo.model.FuncionarioComissionado;
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;

/**
 *
 * @author 0030481521033
 */
public class Aplic {

    public static void main(String[] args) {
        FuncionarioHorista fh = new FuncionarioHorista(1010, "Pedro Silveira", "14/05/1978", 15.80);
        FuncionarioMensalista fm = new FuncionarioMensalista(2020, "Leonardo Amaral", "20/06/2015", 2.50);
        FuncionarioComissionado fc = new FuncionarioComissionado(3030, "Serjão Berranteiro", "21/03/2017", 0.10);
        
        Departamento dp1 = new Departamento("RH", "Recursos Humanos");
        Departamento dp2 = new Departamento("VD", "Vendas");
        
        fh.setDepartamento(dp1);
        fm.setDepartamento(dp1);
        fc.setDepartamento(dp2);
        
        dp1.addFuncionario(fh);
        dp1.addFuncionario(fm);
        dp2.addFuncionario(fc);
        
        System.out.println("O funcionário " + fh.getNome() + " trabalha no departamento " + fh.getDepartamento().getNome());
        System.out.println("O funcionário " + fm.getNome() + " trabalha no departamento " + fm.getDepartamento().getNome());
        System.out.println("O funcionário " + fc.getNome() + " trabalha no departamento " + fc.getDepartamento().getNome());
   
        dp1.listar();
        dp2.listar();
    }
    
}
