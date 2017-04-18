
import fatec.poo.model.Departamento;
import fatec.poo.model.FuncionarioComissionado;
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import fatec.poo.model.Projeto;

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
        
        Projeto pj1 = new Projeto("SI", "Projeto de desenvolvimento e implementação de um sistema de segurança de informação.");
        Projeto pj2 = new Projeto("IMA", "Estudo de impacto das ações da empresa em cima do meio ambiente.");
        
        fh.setDepartamento(dp1);
        fh.setProjeto(pj2);
             
        fm.setDepartamento(dp1);
        fm.setProjeto(pj1);
        
        fc.setDepartamento(dp2);
        fm.setProjeto(pj2);
        
        dp1.addFuncionario(fh);
        dp1.addFuncionario(fm);
        dp2.addFuncionario(fc);
        
        pj1.setDataInicio("18/04/2017");
        pj1.setDataTermino("30/09/2017");
        pj1.addFuncionario(fm);
        
        pj2.setDataInicio("01/01/2017");
        pj2.setDataTermino("05/12/2017");
        pj2.addFuncionario(fh);
        pj2.addFuncionario(fc);
        
        
        System.out.println("O funcionário " + fh.getNome() + " trabalha no departamento " + fh.getDepartamento().getNome());
        System.out.println("O funcionário " + fm.getNome() + " trabalha no departamento " + fm.getDepartamento().getNome());
        System.out.println("O funcionário " + fc.getNome() + " trabalha no departamento " + fc.getDepartamento().getNome());
   
        dp1.listar();
        dp2.listar();
        
        pj1.Listar();
        pj2.Listar();
    }
    
}
