package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author dimas
 */
public class Departamento {
    private String Sigla;
    private String Nome;
    private ArrayList<Funcionario> funcionarios;

    public Departamento(String Sigla, String Nome) {
        this.Sigla = Sigla;
        this.Nome = Nome;
        funcionarios = new ArrayList<Funcionario>();
    }

    public String getSigla() {
        return Sigla;
    }

    public String getNome() {
        return Nome;
    }
    
    public void addFuncionario(Funcionario f){
        funcionarios.add(f);
    }
    
    public void listar(){
        System.out.println("\n\nSigla: " + Sigla);
        System.out.println("Nome : " + Nome);
        System.out.println("Qtde. Funcionários: " + funcionarios.size());
        
        System.out.println("\nRegistro\tNome\t\tTipo");
        for (int i=0; i < funcionarios.size(); i++){
            System.out.print(funcionarios.get(i).getRegistro());
            System.out.print("\t\t" + funcionarios.get(i).getNome());
            if (funcionarios.get(i) instanceof FuncionarioHorista){
                System.out.println("\tHorista");
            }else
              if (funcionarios.get(i) instanceof FuncionarioMensalista){
                   System.out.println("\tMensalista");
              }else{
                   System.out.println("\tComissionado");
              }
        }
    }
}
