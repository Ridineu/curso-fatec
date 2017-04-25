
import fatec.poo.model.Departamento;
import fatec.poo.model.FuncionarioComissionado;
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import fatec.poo.model.Projeto;

/**
 *
 * @author dimas
 */
public class Aplic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FuncionarioHorista funchor = new FuncionarioHorista(1010,
                                                            "Pedro Silveira",
                                                            "14/05/1978",
                                                            15.80);
        FuncionarioMensalista funcmen = new FuncionarioMensalista(2020,
                                                                  "Ana Beatriz",
                                                                  "17/05/1987",
                                                                   2.5);
        
        FuncionarioComissionado funccom = new FuncionarioComissionado(3030, 
                                                                      "Joao Soares",
                                                                      "10/12/1975", 
                                                                      8.5);
    
        Departamento dep1 = new Departamento("RH", "Recursos Humanos");
        Departamento dep2 = new Departamento("VD", "Vendas");
    
        Projeto prj1 = new Projeto("1033", "Seguranca no Trabalho");  
        prj1.setDataInicio("18/04/2017");
        prj1.setDataTermino("23/05/2017");
        
        //Estabelecer a associação binária
        //entre um (1) objeto da classe 
        //Funcionario Horista, Mensalista, Comissionado
        //com um (1) objeto da classe departamento
        funchor.setDepartamento(dep1);
        funcmen.setDepartamento(dep1);
        funccom.setDepartamento(dep2);
        
        System.out.println("O funcionario " + 
                           funchor.getNome() +
                           " trabalha no departamento " +
                            funchor.getDepartamento().getNome());
    
        System.out.println("O funcionario " + 
                            funcmen.getNome() +
                            " trabalha no departamento " +
                            funcmen.getDepartamento().getNome());
        
        System.out.println("O funcionario " +
                            funccom.getNome() +
                            " trabalha no departamento " +
                            funccom.getDepartamento().getNome());
    
        //Estabelecer a associação binária entre um (1)
        //objeto Departamento com um (1) ou mais (*)
        //objetos Funcionario Horista, Mensalista, Comissionado
        dep1.addFuncionario(funchor);
        dep1.addFuncionario(funcmen);
        dep2.addFuncionario(funccom);
        
        dep1.listar();
        dep2.listar();
    
        //estabelecendo a associação binária entre um (1)
        //objeto da classe Funcionario Horista, Mensalista
        //Comissionado com um (1)objeto da classe Projeto
        funchor.setProjeto(prj1);
        funcmen.setProjeto(prj1);
        funccom.setProjeto(prj1);
        
        //estabelecer a associação binária 1..* entre 
        //um(1) objeto Projeto com um(1) ou mais (*)
        //objetos Funcionarios Horista, Mensalista, Comissionado
        prj1.addFuncionario(funchor);
        prj1.addFuncionario(funcmen);
        prj1.addFuncionario(funccom);
        
        prj1.listar();
    }
    
}
